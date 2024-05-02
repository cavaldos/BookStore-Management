
CREATE PROCEDURE AddBook(
    IN bookTitle VARCHAR(255), 
    IN bookPrice DOUBLE, 
    IN bookVolume BIGINT, 
    IN authorName VARCHAR(255), 
    IN categoryName VARCHAR(255), 
    IN publisherName VARCHAR(255)
)
BEGIN
    DECLARE newAuthorID BIGINT DEFAULT 0;
    DECLARE newCategoryID BIGINT DEFAULT 0;
    DECLARE newPublisherID BIGINT DEFAULT 0;
    DECLARE existingBookID BIGINT DEFAULT 0;

    -- Kiểm tra xem sách có tồn tại hay không dựa trên tiêu đề
    SELECT bookID INTO existingBookID FROM book WHERE title = bookTitle LIMIT 1;
    IF existingBookID = 0 THEN
        -- Kiểm tra và thêm mới tác giả nếu cần
        SELECT authorID INTO newAuthorID FROM author WHERE name = authorName LIMIT 1;
        IF newAuthorID = 0 THEN
            INSERT INTO author (name, status) VALUES (authorName, TRUE);   
            SET newAuthorID = LAST_INSERT_ID();
        ELSE
            SELECT authorID INTO newAuthorID FROM author WHERE name = authorName LIMIT 1;
        END IF;
        

        -- Kiểm tra và thêm mới thể loại nếu cần
        SELECT categoryID INTO newCategoryID FROM category WHERE name = categoryName LIMIT 1;
        IF newCategoryID = 0 THEN
            INSERT INTO category (name, status) VALUES (categoryName, TRUE);
            SET newCategoryID = LAST_INSERT_ID();
        ELSE
            SELECT categoryID INTO newCategoryID FROM category WHERE name = categoryName LIMIT 1;
        END IF;

        -- Kiểm tra và thêm mới nhà xuất bản nếu cần
        SELECT publisherID INTO newPublisherID FROM publisher WHERE name = publisherName LIMIT 1;
        IF newPublisherID = 0 THEN
            INSERT INTO publisher (name, status) VALUES (publisherName, TRUE);
            SET newPublisherID = LAST_INSERT_ID();
        ELSE
            SELECT publisherID INTO newPublisherID FROM publisher WHERE name = publisherName LIMIT 1;
        END IF;

        -- Thêm sách mới
        INSERT INTO book (title, price, status, volume, publisherID, categoryID, authorID) 
        VALUES (bookTitle, bookPrice, TRUE, bookVolume, newPublisherID, newCategoryID, newAuthorID);
    ELSE
        -- Thông báo lỗi hoặc xử lý nếu tiêu đề sách đã tồn tại
        SELECT 'Book title already exists' AS ErrorMessage;

    END IF;
END;


---

CREATE PROCEDURE UpdateBook(
    IN p_bookID BIGINT,
    IN p_bookTitle VARCHAR(255), 
    IN p_bookPrice DOUBLE, 
    IN p_bookVolume BIGINT, 
    IN p_authorName VARCHAR(255), 
    IN p_categoryName VARCHAR(255), 
    IN p_publisherName VARCHAR(255),
    IN p_status BOOLEAN  -- Add a parameter for the status
)
BEGIN
    DECLARE v_authorID BIGINT;
    DECLARE v_categoryID BIGINT;
    DECLARE v_publisherID BIGINT;

    -- Get the author ID, or insert a new author if it does not exist
    SELECT authorID INTO v_authorID FROM author WHERE name = p_authorName LIMIT 1;
    IF v_authorID IS NULL THEN
        INSERT INTO author (name, status) VALUES (p_authorName, TRUE);
        SET v_authorID = LAST_INSERT_ID();
    END IF;

    -- Get the category ID, or insert a new category if it does not exist
    SELECT categoryID INTO v_categoryID FROM category WHERE name = p_categoryName LIMIT 1;
    IF v_categoryID IS NULL THEN
        INSERT INTO category (name, status) VALUES (p_categoryName, TRUE);
        SET v_categoryID = LAST_INSERT_ID();
    END IF;

    -- Get the publisher ID, or insert a new publisher if it does not exist
    SELECT publisherID INTO v_publisherID FROM publisher WHERE name = p_publisherName LIMIT 1;
    IF v_publisherID IS NULL THEN
        INSERT INTO publisher (name, status) VALUES (p_publisherName, TRUE);
        SET v_publisherID = LAST_INSERT_ID();
    END IF;

    -- Update the book details including status
    UPDATE book 
    SET title = p_bookTitle, 
        price = p_bookPrice, 
        volume = p_bookVolume, 
        authorID = v_authorID, 
        categoryID = v_categoryID, 
        publisherID = v_publisherID,
        status = p_status  -- Update the status column
    WHERE bookID = p_bookID;

    -- Optionally, you could add logic here to return a success message or handle any errors.
END;


CREATE PROCEDURE `create_order`(
    IN _customerID BIGINT,
    IN _employeeID BIGINT,
    IN _totalCost DOUBLE,
    IN _discount BIGINT,
    IN _status BIGINT
)
BEGIN
    -- Start transaction
    START TRANSACTION;

    -- Step 1: Insert the new order into the orders table and capture the new orderID
    INSERT INTO orders (`date`, `customerID`, `employeeID`, `totalCost`, `discount`, `status`)
    VALUES (CURDATE(), _customerID, _employeeID, _totalCost, _discount, _status);

    -- Capture the orderID of the newly inserted order
    SET @newOrderID = LAST_INSERT_ID();

    -- Step 2: Transfer all entries from order_detail_catche to order_detail
    INSERT INTO order_detail (`orderID`, `bookID`, `quantity`)
    SELECT @newOrderID, `bookID`, `quantity`
    FROM order_detail_catche;



    -- Check for any error occurred during the transaction
    IF ROW_COUNT() = 0 THEN
        -- If no rows were affected, an error might have occurred, rollback the transaction
        ROLLBACK;
        SELECT 'Error occurred, transaction rolled back.' AS Message;
    ELSE
        -- If all operations were successful, commit the transaction
        COMMIT;
        SELECT 'Transaction successful, data committed.' AS Message;
    END IF;

    DELETE FROM order_detail_catche;
END;



CREATE PROCEDURE CreateSheet(
    IN employeeID_value BIGINT
)
BEGIN
    DECLARE newSheetID BIGINT DEFAULT 0;
    DECLARE totalCost_value DOUBLE DEFAULT 0;

    -- Tính tổng chi phí cho các sách nhập không có sheetID
    SELECT SUM(ib.quantity * b.price) INTO totalCost_value
    FROM imported_books ib
    JOIN book b ON ib.bookID = b.bookID
    WHERE ib.sheetID IS NULL;

    -- Chèn dữ liệu vào bảng sheet
    INSERT INTO sheet (employeeID, date, totalCost)
    VALUES (employeeID_value, CURDATE(), totalCost_value);

    -- Lấy ID của bản ghi mới nhất đã chèn vào
    SET newSheetID = LAST_INSERT_ID();

    -- Cập nhật sheetID cho các bản ghi trong imported_books mà chưa có sheetID
    UPDATE imported_books
    SET sheetID = newSheetID
    WHERE sheetID IS NULL;
END;


CREATE TRIGGER `order_detail_catche_before_insert`
BEFORE INSERT ON `order_detail_catche`
FOR EACH ROW
BEGIN
    DECLARE existing_count INT;
    SELECT COUNT(*) INTO existing_count
    FROM `order_detail_catche`
    WHERE `bookID` = NEW.`bookID`;

    IF existing_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot insert duplicate bookID';
    END IF;
END;

CREATE TRIGGER SetBookDate
BEFORE INSERT ON book
FOR EACH ROW
BEGIN
    SET NEW.date = IFNULL(NEW.date, CURDATE());
END;



CREATE TRIGGER BeforeInsertSheet
BEFORE INSERT ON sheet
FOR EACH ROW
BEGIN
    IF NEW.date IS NULL THEN
        SET NEW.date = CURDATE();
    END IF;
END;




CREATE PROCEDURE AddBookSheet(
    IN bookTitle VARCHAR(255), 
    IN bookPrice DOUBLE, 
    IN bookVolume BIGINT, 
    IN authorName VARCHAR(255), 
    IN categoryName VARCHAR(255), 
    IN publisherName VARCHAR(255)
)
BEGIN
    DECLARE newAuthorID BIGINT DEFAULT 0;
    DECLARE newCategoryID BIGINT DEFAULT 0;
    DECLARE newPublisherID BIGINT DEFAULT 0;
    DECLARE existingBookID BIGINT DEFAULT 0;

    -- Kiểm tra xem sách có tồn tại hay không dựa trên tiêu đề
    SELECT bookID INTO existingBookID FROM book WHERE title = bookTitle LIMIT 1;
    IF existingBookID = 0 THEN
        -- Kiểm tra và thêm mới tác giả nếu cần
        SELECT authorID INTO newAuthorID FROM author WHERE name = authorName LIMIT 1;
        IF newAuthorID = 0 THEN
            INSERT INTO author (name, status) VALUES (authorName, TRUE);   
            SET newAuthorID = LAST_INSERT_ID();
        ELSE
            SELECT authorID INTO newAuthorID FROM author WHERE name = authorName LIMIT 1;
        END IF;
        

        -- Kiểm tra và thêm mới thể loại nếu cần
        SELECT categoryID INTO newCategoryID FROM category WHERE name = categoryName LIMIT 1;
        IF newCategoryID = 0 THEN
            INSERT INTO category (name, status) VALUES (categoryName, TRUE);
            SET newCategoryID = LAST_INSERT_ID();
        ELSE
            SELECT categoryID INTO newCategoryID FROM category WHERE name = categoryName LIMIT 1;
        END IF;

        -- Kiểm tra và thêm mới nhà xuất bản nếu cần
        SELECT publisherID INTO newPublisherID FROM publisher WHERE name = publisherName LIMIT 1;
        IF newPublisherID = 0 THEN
            INSERT INTO publisher (name, status) VALUES (publisherName, TRUE);
            SET newPublisherID = LAST_INSERT_ID();
        ELSE
            SELECT publisherID INTO newPublisherID FROM publisher WHERE name = publisherName LIMIT 1;
        END IF;

        -- Thêm sách mới
        INSERT INTO book (title, price, status, volume, publisherID, categoryID, authorID) 
        VALUES (bookTitle, bookPrice, TRUE, bookVolume, newPublisherID, newCategoryID, newAuthorID);
        
        -- Lấy ID của sách vừa thêm
        SET existingBookID = LAST_INSERT_ID();
    ELSE
        -- Thông báo lỗi hoặc xử lý nếu tiêu đề sách đã tồn tại
        SELECT 'Book title already exists' AS ErrorMessage;
    END IF;

    -- Cập nhật cột volume của sách
    UPDATE book SET volume = volume + bookVolume WHERE bookID = existingBookID;

    -- Chèn dữ liệu vào imported_books
    INSERT INTO imported_books (bookID, quantity, sheetID) VALUES (existingBookID, bookVolume, NULL);
    
END;






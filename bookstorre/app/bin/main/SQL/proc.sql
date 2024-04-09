CREATE PROCEDURE AddBook(
    IN bookTitle VARCHAR(255), 
    IN bookPrice DOUBLE, 
    IN bookVolume BIGINT, 
    IN authorName VARCHAR(255), 
    IN categoryName VARCHAR(255), 
    IN publisherName VARCHAR(255)
)
BEGIN
    DECLARE authorID BIGINT DEFAULT 0;
    DECLARE categoryID BIGINT DEFAULT 0;
    DECLARE publisherID BIGINT DEFAULT 0;
    DECLARE existingBookID BIGINT DEFAULT 0;

    -- Kiểm tra xem sách có tồn tại hay không dựa trên tiêu đề
    SELECT bookID INTO existingBookID FROM book WHERE title = bookTitle LIMIT 1;
    IF existingBookID = 0 THEN
        -- Kiểm tra và thêm mới tác giả nếu cần
        SELECT authorID INTO authorID FROM author WHERE name = authorName LIMIT 1;
        IF authorID = 0 THEN
            INSERT INTO author (name, status) VALUES (authorName, TRUE);
            SET authorID = LAST_INSERT_ID();
        END IF;

        -- Kiểm tra và thêm mới thể loại nếu cần
        SELECT categoryID INTO categoryID FROM category WHERE name = categoryName LIMIT 1;
        IF categoryID = 0 THEN
            INSERT INTO category (name, status) VALUES (categoryName, TRUE);
            SET categoryID = LAST_INSERT_ID();
        END IF;

        -- Kiểm tra và thêm mới nhà xuất bản nếu cần
        SELECT publisherID INTO publisherID FROM publisher WHERE name = publisherName LIMIT 1;
        IF publisherID = 0 THEN
            INSERT INTO publisher (name, status) VALUES (publisherName, TRUE);
            SET publisherID = LAST_INSERT_ID();
        END IF;

        -- Thêm sách mới
        INSERT INTO book (title, price, status, volume, publisherID, categoryID, authorID) 
        VALUES (bookTitle, bookPrice, TRUE, bookVolume, publisherID, categoryID, authorID);
    ELSE
        -- Thông báo lỗi hoặc xử lý nếu tiêu đề sách đã tồn tại
        SELECT 'Book title already exists' AS ErrorMessage;
    END IF;
END;


--(bookTitle, bookPrice, bookVolume, authorName, categoryName, publisherName)
-- 
CALL AddBook('Book 199', 10000, 1, 'Author 1', 'Category 1', 'Publisher 1');




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
CALL UpdateBook(31, 'kyl', 19.99, 6, 'New Author Name', 'New Category Name', 'New Publisher Name', TRUE);
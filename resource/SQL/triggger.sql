

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


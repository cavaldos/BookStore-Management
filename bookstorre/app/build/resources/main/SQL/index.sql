

CREATE DATABASE IF NOT EXISTS book_store;

USE book_store;

CREATE TABLE IF NOT EXISTS `account` (
  `userID` BIGINT AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `status` BOOLEAN NOT NULL,
  `role` CHAR(10) NOT NULL,
  `firstname` VARCHAR(255),
  `lastname` VARCHAR(255),
  PRIMARY KEY (`userID`),
    CHECK (`role` IN ('admin', 'employee'))

);

CREATE TABLE IF NOT EXISTS `customer` (
  `customerID` BIGINT AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL UNIQUE,
  `firstname` VARCHAR(255),
  `lastname` VARCHAR(255),
  PRIMARY KEY (`customerID`)
);


CREATE TABLE IF NOT EXISTS `author` (
  `authorID` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL UNIQUE,
  `status` BOOLEAN NOT NULL,
  PRIMARY KEY (`authorID`)
);

CREATE TABLE IF NOT EXISTS `publisher` (
  `publisherID` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL UNIQUE,
  `status` BOOLEAN NOT NULL,
  PRIMARY KEY (`publisherID`)
);

CREATE TABLE IF NOT EXISTS `category` (
  `categoryID` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL UNIQUE,
  `status` BOOLEAN NOT NULL,
  PRIMARY KEY (`categoryID`)
);

CREATE TABLE IF NOT EXISTS `book` (
  `bookID` BIGINT AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL UNIQUE,
  `author` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  `status` BOOLEAN NOT NULL,
  `volume` BIGINT,
  `publisherID` BIGINT,
  `categoryID` BIGINT,
  `authorID` BIGINT,
  PRIMARY KEY (`bookID`),
  FOREIGN KEY (`publisherID`) REFERENCES `publisher` (`publisherID`) ON DELETE SET NULL,
  FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`) ON DELETE SET NULL,
  FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`) ON DELETE SET NULL
);
CREATE TABLE IF NOT EXISTS `orders` (
  `orderID` BIGINT AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `customerID` BIGINT,
  `employeeID` BIGINT NOT NULL,
  `totalCost` DOUBLE NOT NULL,
  `discount` BIGINT NOT NULL,
  `status` BIGINT NOT NULL,
  PRIMARY KEY (`orderID`),
  FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE,
  FOREIGN KEY (`employeeID`) REFERENCES `account` (`userID`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `order_detail` (
  `id_order_detail` BIGINT AUTO_INCREMENT,
  `orderID` BIGINT NOT NULL,
  `bookID` BIGINT NOT NULL,
  `quantity` BIGINT NOT NULL,
  PRIMARY KEY (`id_order_detail`),
  FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE,
  FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE
);
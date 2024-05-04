package store.helper;

import store.Model.Book;
import store.Service.BookService;

import store.Model.OrderDetail;
import store.Service.OrderService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BookHelper {
    private BookService bookService;

    public BookHelper() {
        this.bookService = new BookService();
    }

    public Book newBook1() {
        try {
            List<Book> books = bookService.getAllBooks();
            if (books.isEmpty()) {
                return null; // Trả về null nếu không có sách nào trong cơ sở dữ liệu
            }
            Collections.sort(books, (b1, b2) -> Integer.compare(b2.getBookID(), b1.getBookID()));
            Book latestBook = books.get(0); // Lấy sách có giá trị IDBook lớn nhất
            String title = latestBook.getTitle();
            String author = latestBook.getAuthor();
            double price = latestBook.getPrice();
            return new Book(title, author, price); // Trả về sách mới chỉ có title, author, và price
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book newBook2() {
        try {
            List<Book> books = bookService.getAllBooks();
            if (books.size() < 2) {
                return null; // Trả về null nếu không có đủ sách trong cơ sở dữ liệu
            }
            Collections.sort(books, (b1, b2) -> Integer.compare(b2.getBookID(), b1.getBookID()));
            Book secondLatestBook = books.get(1); // Lấy sách có IDBook lớn thứ hai
            String title = secondLatestBook.getTitle();
            String author = secondLatestBook.getAuthor();
            double price = secondLatestBook.getPrice();
            return new Book(title, author, price); // Trả về sách mới chỉ có title, author, và price
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book newBook3() {
        try {
            List<Book> books = bookService.getAllBooks();
            if (books.size() < 3) {
                return null; // Trả về null nếu không có đủ sách trong cơ sở dữ liệu
            }
            Collections.sort(books, (b1, b2) -> Integer.compare(b2.getBookID(), b1.getBookID()));
            Book thirdLatestBook = books.get(2); // Lấy sách có IDBook lớn thứ ba
            String title = thirdLatestBook.getTitle();
            String author = thirdLatestBook.getAuthor();
            double price = thirdLatestBook.getPrice();
            return new Book(title, author, price); // Trả về sách mới chỉ có title, author, và price
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // public Book hotBook1() {
    // try {
    // List<Order> books = bookService.getAllBooks();
    // if (books.isEmpty()) {
    // return null; // Trả về null nếu không có sách nào trong cơ sở dữ liệu
    // }
    // Collections.sort(books, (b1, b2) -> Integer.compare(b2.getSoldQuantity(),
    // b1.getSoldQuantity()));
    // Book hotBook1 = books.get(0);
    // String title = hotBook1.getTitle();
    // String author = hotBook1.getAuthor();
    // double price = hotBook1.getPrice();
    // return new Book(title, author, price); // Trả về sách mới chỉ có title,
    // author, và price
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return null;
    // }
    // }

    // public Book hotBook2() {
    // try {
    // List<Order> books = bookService.getAllBooks();
    // if (books.size() < 2) {
    // return null; // Trả về null nếu không có đủ sách trong cơ sở dữ liệu
    // }
    // Collections.sort(books, (b1, b2) -> Integer.compare(b2.getSoldQuantity(),
    // b1.getSoldQuantity()));
    // Book hotBook2 = books.get(1);
    // String title = hotBook2.getTitle();
    // String author = hotBook2.getAuthor();
    // double price = hotBook2.getPrice();
    // return new Book(title, author, price); // Trả về sách mới chỉ có title,
    // author, và price
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return null;
    // }
    // }

    // public Book hotBook3() {
    // try {
    // List<Book> books = bookService.getAllBooks();
    // if (books.size() < 3) {
    // return null; // Trả về null nếu không có đủ sách trong cơ sở dữ liệu
    // }
    // Collections.sort(books, (b1, b2) -> Integer.compare(b2.getSoldQuantity(),
    // b1.getSoldQuantity()));
    // Book hotBook3 = books.get(2);
    // String title = hotBook3.getTitle();
    // String author = hotBook3.getAuthor();
    // double price = hotBook3.getPrice();
    // return new Book(title, author, price); // Trả về sách mới chỉ có title,
    // author, và price
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return null;
    // }
    // }
}
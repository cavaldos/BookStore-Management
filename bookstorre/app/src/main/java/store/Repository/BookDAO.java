package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Book;
import store.utils.DatabaseUtils;

public class BookDAO {

    // add book
    public void insertBook(Book book) throws SQLException {
        // --(bookTitle,bookPrice,bookVolume,authorName,categoryName,publisherName)
        // CALL AddBook('Book 199', 10000, 1, 'Author 1', 'Category 1', 'Publisher 1');
        String INSERT_BOOK_SQL = "CALL AddBook (?,?,?,?,?,?)";
        try (@SuppressWarnings("static-access")
        Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setDouble(2, book.getPrice());
            preparedStatement.setInt(3, book.getVolume());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setString(5, book.getCategory());
            preparedStatement.setString(6, book.getPublisher());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // delete book
    public boolean deleteBook(int bookID) throws SQLException {
        String DELETE_BOOK_SQL = "DELETE FROM book WHERE bookID = ?";

        try (@SuppressWarnings("static-access")
        Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            preparedStatement.setInt(1, bookID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // update book
    public boolean updateBook(Book book) throws SQLException {
        // -- (bookID, title, price, volume, author, category, publisher, status)
        // CALL UpdateBook(31, 'kyl', 19.99, 5, 'New Author Name', 'New Category
        // ',Name','New Publisher Name');
        String UPDATE_BOOK_SQL = "CALL UpdateBook(?,?,?,?,?,?,?,?)";
        try (@SuppressWarnings("static-access")
        Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            preparedStatement.setLong(1, book.getBookID());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setLong(4, book.getVolume());
            preparedStatement.setString(5, book.getAuthor());
            preparedStatement.setString(6, book.getCategory());
            preparedStatement.setString(7, book.getPublisher());
            preparedStatement.setBoolean(8, book.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // get book by id
    public Book selectBook(int bookID) throws SQLException {
        String SELECT_BOOK_BY_ID = "SELECT book.title, book.price, author.name as author, publisher.name as publisher, category.name as category, book.volume , book.status "
                + //
                "FROM book " + //
                "JOIN author ON book.authorID = author.authorID " + //
                "JOIN publisher ON book.publisherID = publisher.publisherID " + //
                "JOIN category ON book.categoryID = category.categoryID " + //
                "WHERE book.bookID = ?"; //

        Book book = null;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setLong(1, bookID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                boolean status = rs.getBoolean("status");
                int volume = rs.getInt("volume");
                book = new Book(bookID, title, author, publisher, price, category, status, volume);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return book;
    }

    // get all books
    public List<Book> getAllBooks() throws SQLException {
        String SELECT_ALL_BOOKS = "SELECT book.bookID, book.title, author.name AS authorName, publisher.name AS publisherName, book.price, category.name AS categoryName, book.status , book.volume\n"
                + //
                "FROM book\n" + //
                "JOIN author ON book.authorID = author.authorID\n" + //
                "JOIN publisher ON book.publisherID = publisher.publisherID\n" + //
                "JOIN category ON book.categoryID = category.categoryID;\n" + //
                ""; //
        List<Book> books = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int bookID = rs.getInt("bookID");
                String title = rs.getString("title");
                String author = rs.getString("authorName"); // Đọc trường tên tác giả dưới dạng chuỗi
                String publisher = rs.getString("publisherName"); // Đọc trường tên nhà xuất bản dưới dạng chuỗi
                double price = rs.getDouble("price");
                String category = rs.getString("categoryName");
                boolean status = rs.getBoolean("status");
                int volume = rs.getInt("volume");

                // Create a new Book object and set its properties
                Book book = new Book(bookID, title, author, publisher, price, category, status, volume);

                // Add the book object to the list of books
                books.add(book);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

}

package store.Repository;

import store.utils.DatabaseUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import store.Model.Sheet;
import store.Model.Book;
import store.Model.Book;

public class SheetDAO {

    // create sheet
    public void createSheet(Sheet sheet) throws SQLException {
        // value (employee ID)
        // call CreateSheet(1);

        String sql = "CALL CreateSheet(?)";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, sheet.getEmployeeID());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // addbook

    public void importBookSheet(Book book) throws SQLException {
        // --(bookTitle,bookPrice,bookVolume,authorName,categoryName,publisherName)
        // CALL AddBookSheet('Book 199', 10000, 1, 'Author 1', 'Category 1', 'Publisher
        // 1');
        String INSERT_BOOK_SQL = "CALL AddBookSheet (?,?,?,?,?,?)";
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

    // get all book importing
    public List<Book> getAllBookImporting() throws SQLException {
        String query = "select b.bookID, b.title, a.name as authorName, p.name as publisherName, c.name as categoryName, b.price, imb.quantity as volume,b.status\n" + //
                        "from book b\n" + //
                        "join author a on b.authorID = a.authorID\n" + //
                        "join category c on b.categoryID = c.categoryID\n" + //
                        "join publisher p on b.publisherID = p.publisherID\n" + //
                        "JOIN imported_books imb  on b.bookID = imb.bookID\n" + //
                        "where imb.sheetID is null;";
        List<Book> books = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int bookID = rs.getInt("bookID");
                String title = rs.getString("title");
                String author = rs.getString("authorName"); // Đọc trường tên tác giả dưới dạng chuỗi
                String publisher = rs.getString("publisherName"); // Đọc trường tên nhà xuất bản dưới dạng chuỗi
                double price = rs.getDouble("price");
                String category = rs.getString("categoryName");
                boolean status = rs.getBoolean("status");
                int volume = rs.getInt("volume");
                Book book = new Book(bookID, title, author, publisher, price, category, status, volume);

                books.add(book);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    //delete sheet
    public void deleteSheetImporting() throws SQLException {
        String sql = "delete from imported_books where sheetID is null;";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // get all sheet
    public List<Sheet> getAllSheet() throws SQLException {
        String query = "select s.sheetID, a.username as employee, s.date, s.totalCost\n" + //
                "from sheet s\n" + //
                "join account a on a.userID = s.employeeID\n" + //
                "";
        List<Sheet> sheets = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int sheetID = resultSet.getInt("sheetID");
                String employee = resultSet.getString("employee");
                String date = resultSet.getString("date");
                Double totalCost = resultSet.getDouble("totalCost");
                Sheet sheet = new Sheet(sheetID, employee, date, totalCost);
                sheets.add(sheet);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sheets;
    }

}

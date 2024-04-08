package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Author;
import store.utils.DatabaseUtils;

public class AuthorDAO {
    private static final String INSERT_AUTHOR_SQL = "INSERT INTO author (name) VALUES (?)";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT authorID, name, status FROM author WHERE authorID = ?";
    private static final String SELECT_ALL_AUTHORS = "SELECT authorID, name, status FROM author";
    private static final String UPDATE_AUTHOR_SQL = "UPDATE author SET name = ?, status = ? WHERE authorID = ?";
    private static final String DELETE_AUTHOR_SQL = "DELETE FROM author WHERE authorID = ?";

    // add author
    public void addAuthor(Author author) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR_SQL)) {
            preparedStatement.setString(2, author.getAuthorName());
            preparedStatement.setBoolean(3, author.getStatus());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update author
    public boolean updateAuthor(Author author) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL)) {
            statement.setString(1, author.getAuthorName());
            statement.setBoolean(2, author.getStatus());
            statement.setInt(3, author.getAuthorID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // disable author
    public boolean disableAuthor(String authorID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL)) {
            statement.setBoolean(2, false);
            statement.setString(3, authorID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // enable author

    public boolean enableAuthor(String authorID) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_SQL)) {
            statement.setBoolean(2, true);
            statement.setString(3, authorID);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // get author by id
    public Author selectAuthor(int authorID) throws SQLException {
        Author author = null;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID)) {
            preparedStatement.setInt(1, authorID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String authorName = rs.getString("name");
                Boolean status = rs.getBoolean("status");
                author = new Author(authorID, authorName, status);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return author;
    }


    // delete author
    public void deleteAuthor(int authorID) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AUTHOR_SQL)) {
            preparedStatement.setInt(1, authorID);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    
    }

    // get all authors
    public List<Author> getAllAuthors() throws SQLException {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int authorID = rs.getInt("authorID");
                String authorName = rs.getString("name");
                Boolean status = rs.getBoolean("status");
                Author author = new Author(authorID, authorName, status);
                authors.add(author);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return authors;
    }


}

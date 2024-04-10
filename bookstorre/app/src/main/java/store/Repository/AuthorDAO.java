package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Author;
import store.utils.DatabaseUtils;

public class AuthorDAO {

    // add author
    public void addAuthor(Author author) throws SQLException {
        String INSERT_AUTHOR_SQL = "INSERT INTO author (name, status) VALUES (?,TRUE)";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR_SQL)) {
            preparedStatement.setString(1, author.getAuthorName());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update author
    public boolean updateAuthor(Author author) throws SQLException {
        String UPDATE_AUTHOR_SQL = "UPDATE author SET name = ?, status = ? WHERE authorID = ?";
        boolean rowUpdated;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
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

    // get author by id
    public Author selectAuthor(int authorID) throws SQLException {
        String SELECT_AUTHOR_BY_ID = "SELECT authorID, name, status FROM author WHERE authorID = ?";
        Author author = null;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
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
        String DELETE_AUTHOR_SQL = "DELETE FROM author WHERE authorID = ?";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AUTHOR_SQL)) {
            preparedStatement.setInt(1, authorID);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    
    }

    // get all authors
    public List<Author> getAllAuthors() throws SQLException {
        String SELECT_ALL_AUTHORS = "SELECT authorID, name, status FROM author";
        List<Author> authors = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
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

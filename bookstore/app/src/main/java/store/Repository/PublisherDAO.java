package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Publisher;
import store.utils.DatabaseUtils;

public class PublisherDAO {

    // add publisher
    public void addPublisher(String publisher) throws SQLException {
        String INSERT_PUBLISHER_SQL = "INSERT INTO publisher (name, status) VALUES (?, TRUE)";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PUBLISHER_SQL)) {
            preparedStatement.setString(1, publisher);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update publisher
    public boolean updatePublisher(Publisher publisher) throws SQLException {
        String UPDATE_PUBLISHER_SQL = "UPDATE publisher SET name = ?, status = ? WHERE publisherID = ?";
        boolean rowUpdated;
        new DatabaseUtils();

        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_PUBLISHER_SQL)) {
            statement.setString(1, publisher.getPublisherName());
            statement.setBoolean(2, publisher.getStatus());
            statement.setInt(3, publisher.getPublisherID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // select publisher by id
    public Publisher selectPublisher(int publisherID) {
        String SELECT_PUBLISHER_BY_ID = "SELECT publisherID, name, status FROM publisher WHERE publisherID = ?";
        Publisher publisher = null;
        new DatabaseUtils();

        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PUBLISHER_BY_ID)) {
            preparedStatement.setInt(1, publisherID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String publisherName = rs.getString("name");
                Boolean status = rs.getBoolean("status");
                publisher = new Publisher(publisherID, publisherName, status);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    // select all publishers
    public List<Publisher> getAllPublishers() {
        String SELECT_ALL_PUBLISHERS = "SELECT publisherID, name, status FROM publisher";
        List<Publisher> publishers = new ArrayList<>();
        new DatabaseUtils();

        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PUBLISHERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int publisherID = rs.getInt("publisherID");
                String publisherName = rs.getString("name");
                Boolean status = rs.getBoolean("status");
                Publisher publisher = new Publisher(publisherID, publisherName, status);
                publishers.add(publisher);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    // delete publisher
    public boolean deletePublisher(int publisherID) throws SQLException {
        String DELETE_PUBLISHER_SQL = "DELETE FROM publisher WHERE publisherID = ?";
        new DatabaseUtils();

        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PUBLISHER_SQL)) {
            preparedStatement.setInt(1, publisherID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}

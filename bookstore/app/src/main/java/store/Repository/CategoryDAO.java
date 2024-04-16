package store.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import store.Model.Category;
import store.utils.DatabaseUtils;

public class CategoryDAO {

    // add category
    public void addCategory(String category) throws SQLException {
        String INSERT_CATEGORY_SQL = "INSERT INTO `category` (name, status) VALUES (?, TRUE)";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update category
    public boolean updateCategory(Category category) throws SQLException {
        boolean rowUpdated;
        String UPDATE_CATEGORY_SQL = "UPDATE category SET name = ?, status = ? WHERE categoryID = ?";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL)) {
            statement.setString(1, category.getCategoryName());
            statement.setBoolean(2, category.getStatus());
            statement.setInt(3, category.getCategoryID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    // get category by id
    public Category selectCategory(int categoryID) throws SQLException {
        String SELECT_CATEGORY_BY_ID = "SELECT categoryID, name, status FROM category WHERE categoryID = ?";
        Category category = null;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1, categoryID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String categoryName = rs.getString("name");
                Boolean status = rs.getBoolean("status");
                category = new Category(categoryID, categoryName, status);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return category;
    }

    // get all categories
    public List<Category> getAllCategories() throws SQLException, ClassNotFoundException {
        String SELECT_ALL_CATEGORIES = "SELECT categoryID, name, status FROM category";
        List<Category> categories = new ArrayList<>();
        new DatabaseUtils(); 
        try (Connection connection = DatabaseUtils.connect(); // Call connect() on the instance
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int categoryID = rs.getInt("categoryID");
                String categoryName = rs.getString("name");
                boolean status = rs.getBoolean("status");
                Category category = new Category(categoryID, categoryName, status);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    // delete category
    public boolean deleteCategory(int categoryID) throws SQLException {
        String DELETE_CATEGORY_SQL = "DELETE FROM category WHERE categoryID = ?";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_SQL)) {
            preparedStatement.setInt(1, categoryID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}

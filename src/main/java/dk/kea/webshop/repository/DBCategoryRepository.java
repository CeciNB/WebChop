package dk.kea.webshop.repository;

import dk.kea.webshop.model.Category;
import dk.kea.webshop.util.DatabaseConnectionManager;
import dk.kea.webshop.util.ICrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DBCategoryRepository implements ICrudRepository<Category> {

    private Connection conn;

    public DBCategoryRepository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public void create(Category category) {
        String sqlStatement = "INSERT IGNORE INTO category (category_id, category_name,) VALUES  (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, category.getId());
            ps.setString(2, category.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sqlStatement2 = "UPDATE products SET category_id = ? WHERE product_id = ?";
        try {
            PreparedStatement ps2 = conn.prepareStatement(sqlStatement2);
            ps2.setLong(1, category.getId());
            ps2.setLong(2, category.getProductId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Category> readAll() {
        ArrayList<Category> categories = new ArrayList<>();
        String sqlStatement = "SELECT  * FROM category";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category(
                        rs.getLong("category_id"),
                        rs.getString("category_name")
                );
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category read(long id) {
        Category category = null;
        String sqlStatement = "SELECT * FROM category WHERE category_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                category = new Category(
                        rs.getLong("company_description_id"),
                        rs.getString("company_description_name")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public boolean update(Category category) {
        boolean result = false;
        String sqlStatement = "UPDATE category SET category_name = ? WHERE category_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setString(1, category.getName());
            ps.setLong(2, category.getId());
            int rowInserted = ps.executeUpdate();
            if (rowInserted > 0){
                System.out.println("succes!");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(long id) {
        boolean result = false;
        String sqlStatement = "DELETE FROM category WHERE category_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, id);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("succes!");
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}

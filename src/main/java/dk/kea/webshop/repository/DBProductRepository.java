package dk.kea.webshop.repository;

import dk.kea.webshop.model.Product;
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
public class DBProductRepository implements ICrudRepository<Product> {

    private Connection conn;

    public DBProductRepository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public List<Product> readAll(){
        ArrayList<Product> products = new ArrayList<>();
        String sqlStatement = "SELECT * FROM products;";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setDescription(rs.getString("product_description"));
                product.setPrice(rs.getDouble("product_price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void create(Product product){
        String sqlStatement = "INSERT INTO products (product_id,product_name,product_description,product_price) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setInt(1, (int) product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product read(long id) {
        Product product = new Product();
        String sqlStatement = "SELECT * FROM products WHERE product_id = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                product = new Product();
                product.setId(rs.getLong("product_id"));
                product.setName(rs.getString("product_name"));
                product.setDescription(rs.getString("product_description"));
                product.setPrice(rs.getDouble("product_price"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        boolean result = false;
        String sqlStatement = "UPDATE products SET product_name = ?, product_description = ?, product_price = ? WHERE product_id = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setLong(4, product.getId());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("successfull!");
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(long id) {
        boolean result = false;
        String sqlStatement = "DELETE FROM products WHERE product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, id);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("successfull!");
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

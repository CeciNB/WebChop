package dk.kea.webshop.repository;

import dk.kea.webshop.model.Company;
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
public class DBCompanyRepository implements ICrudRepository<Company> {

    private Connection conn;

    public DBCompanyRepository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public void create(Company company) {
        String sqlStatement = "INSERT IGNORE INTO company (company_id, company_name,) VALUES  (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, company.getId());
            ps.setString(2, company.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sqlStatement2 = "UPDATE products SET company_id = ? WHERE product_id = ?";
        try {
            PreparedStatement ps2 = conn.prepareStatement(sqlStatement2);
            ps2.setLong(1, company.getId());
            ps2.setLong(2, company.getProductId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Company> readAll() {
        ArrayList<Company> companies = new ArrayList<>();
        String sqlStatement = "SELECT  * FROM company";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Company company = new Company(
                        rs.getLong("company_id"),
                        rs.getString("company_name")
                );
                companies.add(company);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return companies;
    }

    @Override
    public Company read(long id) {
        Company company = null;
        String sqlStatement = "SELECT company.company_id, company.company_name\n" +
                "FROM products\n" +
                "INNER JOIN company ON products.company_id = company.company_id\n" +
                "WHERE product_id = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                company = new Company(
                        rs.getLong("company.company_id"),
                        rs.getString("company.company_name")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("FELJ");
        }
        return company;
    }


    @Override
    public boolean update(Company company) {
        boolean result = false;
        String sqlStatement = "UPDATE company SET company_name = ? WHERE company_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setString(1, company.getName());
            ps.setLong(2, company.getId());
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
        String sqlStatement = "DELETE FROM company WHERE company_id = ?";
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

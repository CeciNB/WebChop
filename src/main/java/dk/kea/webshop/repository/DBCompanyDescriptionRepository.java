package dk.kea.webshop.repository;

import dk.kea.webshop.model.CompanyDescription;
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
public class DBCompanyDescriptionRepository implements ICrudRepository<CompanyDescription> {

    private Connection conn;

    public DBCompanyDescriptionRepository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public void create(CompanyDescription companyDescription) {
        String sqlStatement = "INSERT IGNORE INTO company_description (company_description_id, company_description_name,) VALUES  (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, companyDescription.getId());
            ps.setString(2, companyDescription.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sqlStatement2 = "UPDATE products SET company_description_id = ? WHERE product_id = ?";
        try {
            PreparedStatement ps2 = conn.prepareStatement(sqlStatement2);
            ps2.setLong(1, companyDescription.getId());
            ps2.setLong(2, companyDescription.getProductId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<CompanyDescription> readAll() {
        ArrayList<CompanyDescription> companyDescriptions = new ArrayList<>();
        String sqlStatement = "SELECT  * FROM company_description";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                CompanyDescription company = new CompanyDescription(
                        rs.getLong("company_description_id"),
                        rs.getString("company_description_name")
                );
                companyDescriptions.add(company);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return companyDescriptions;
    }

    @Override
    public CompanyDescription read(long id) {
        CompanyDescription companyDescription = null;
        String sqlStatement = "SELECT * FROM company_description WHERE company_description_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                companyDescription = new CompanyDescription(
                        rs.getLong("company_description_id"),
                        rs.getString("company_description_name")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return companyDescription;
    }

    @Override
    public boolean update(CompanyDescription companyDescription) {
        boolean result = false;
        String sqlStatement = "UPDATE company_description SET company_description_name = ? WHERE company_description_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlStatement);
            ps.setString(1, companyDescription.getName());
            ps.setLong(2, companyDescription.getId());
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
        String sqlStatement = "DELETE FROM company_description WHERE company_description_id = ?";
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

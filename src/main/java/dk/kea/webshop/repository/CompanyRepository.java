package dk.kea.webshop.repository;

import dk.kea.webshop.model.Company;
import dk.kea.webshop.util.ICrudRepository;

import java.util.List;

public class CompanyRepository implements ICrudRepository<Company> {
    @Override
    public void create(Company company) {

    }

    @Override
    public List<Company> readAll() {
        return null;
    }

    @Override
    public Company read(long id) {
        return null;
    }

    @Override
    public boolean update(Company company) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

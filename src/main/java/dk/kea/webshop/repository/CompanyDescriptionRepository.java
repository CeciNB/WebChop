package dk.kea.webshop.repository;

import dk.kea.webshop.model.CompanyDescription;
import dk.kea.webshop.util.ICrudRepository;

import java.util.List;

public class CompanyDescriptionRepository implements ICrudRepository<CompanyDescription> {
    @Override
    public void create(CompanyDescription companyDescription) {

    }

    @Override
    public List<CompanyDescription> readAll() {
        return null;
    }

    @Override
    public CompanyDescription read(long id) {
        return null;
    }

    @Override
    public boolean update(CompanyDescription companyDescription) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

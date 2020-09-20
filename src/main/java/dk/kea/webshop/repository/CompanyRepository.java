package dk.kea.webshop.repository;

import dk.kea.webshop.model.Company;
import dk.kea.webshop.util.ICrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository implements ICrudRepository<Company> {

    private List<Company> companies = new ArrayList<>();

    public CompanyRepository() {
        this.companies.add(new Company(1,"Elle",1));
        this.companies.add(new Company(2,"Coop",2));
        this.companies.add(new Company(3,"Andet",3));
    }

    @Override
    public void create(Company company) {
        companies.add(company);
    }

    @Override
    public List<Company> readAll() {
        return companies;
    }

    @Override
    public Company read(long id) {
        int i=0;
        while (i< companies.size()){
            if (companies.get(i).getProductId()==id)
                return companies.get(i);
            i++;
        }
        return null;
    }

    @Override
    public boolean update(Company company) {
        for (int i = 0; i< companies.size(); i++){
            if (companies.get(i).getId() == company.getId()){
                companies.set(i, company);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        int i=0;
        while (i< companies.size()){
            if (companies.get(i).getId() == id){
                companies.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}

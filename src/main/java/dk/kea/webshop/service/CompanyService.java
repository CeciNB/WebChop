package dk.kea.webshop.service;

import dk.kea.webshop.model.Company;
import dk.kea.webshop.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> readAll(){
        List<Company> companies = new ArrayList<>();
        for (Company company : companyRepository.readAll()){
            companies.add(company);
        }

        return companies;
    }

    public void create(Company company){
        companyRepository.create(company);
    }

    public boolean update(Company company){

        boolean updateOK = companyRepository.update(company);
        return updateOK;
    }

    public Company read(long id){
        return companyRepository.read(id);
    }

    public boolean delete(long id){
        return companyRepository.delete(id);
    }
}

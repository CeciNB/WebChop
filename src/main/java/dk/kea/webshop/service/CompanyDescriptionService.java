package dk.kea.webshop.service;

import dk.kea.webshop.model.Company;
import dk.kea.webshop.model.CompanyDescription;
import dk.kea.webshop.repository.CompanyDescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CompanyDescriptionService {
    @Autowired
    CompanyDescriptionRepository companyDescriptionRepository;

    public List<CompanyDescription> readAll(){
        List<CompanyDescription> companyDescriptions = new ArrayList<>();
        for (CompanyDescription companyDescription : companyDescriptionRepository.readAll()){
            companyDescriptions.add(companyDescription);
        }

        return companyDescriptions;
    }

    public void create(CompanyDescription companyDescription){
        companyDescriptionRepository.create(companyDescription);
    }

    public boolean update(CompanyDescription companyDescription){
        return companyDescriptionRepository.update(companyDescription);
    }

    public CompanyDescription read(long id){
        return companyDescriptionRepository.read(id);
    }

    public boolean delete(long id){
        return companyDescriptionRepository.delete(id);
    }
}

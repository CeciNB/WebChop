package dk.kea.webshop.repository;

import dk.kea.webshop.model.CompanyDescription;
import dk.kea.webshop.util.ICrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CompanyDescriptionRepository implements ICrudRepository<CompanyDescription> {

    private List<CompanyDescription> companyDescriptions = new ArrayList<>();

    public CompanyDescriptionRepository() {
        this.companyDescriptions.add(new CompanyDescription(1,"Makeup",1));
        this.companyDescriptions.add(new CompanyDescription(2,"Madvarer",2));
        this.companyDescriptions.add(new CompanyDescription(3,"Noget andet",3));
    }

    @Override
    public void create(CompanyDescription companyDescription) {
        companyDescriptions.add(companyDescription);
    }

    @Override
    public List<CompanyDescription> readAll() {
        return companyDescriptions;
    }

    @Override
    public CompanyDescription read(long id) {
        int i=0;
        while (i< companyDescriptions.size()){
            if (companyDescriptions.get(i).getProductId()==id)
                return companyDescriptions.get(i);
            i++;
        }
        return null;
    }

    @Override
    public boolean update(CompanyDescription companyDescription) {
        for (int i = 0; i< companyDescriptions.size(); i++){
            if (companyDescriptions.get(i).getId() == companyDescription.getId()){
                companyDescriptions.set(i, companyDescription);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        int i=0;
        while (i< companyDescriptions.size()){
            if (companyDescriptions.get(i).getId()==id){
                companyDescriptions.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}

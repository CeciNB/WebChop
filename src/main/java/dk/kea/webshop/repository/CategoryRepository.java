package dk.kea.webshop.repository;

import dk.kea.webshop.model.Category;
import dk.kea.webshop.util.ICrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements ICrudRepository<Category> {

    private List<Category> categories = new ArrayList<>();

    public CategoryRepository() {
        this.categories.add(new Category(1,"maling",1));
        this.categories.add(new Category(2,"maling",2));
        this.categories.add(new Category(3,"maling",3));
    }

    @Override
    public void create(Category category) {
        categories.add(category);
    }

    @Override
    public List<Category> readAll() {
        return categories;
    }

    @Override
    public Category read(long id) {
        int i=0;
        while (i< categories.size()){
            if (categories.get(i).getProductId()==id)
                return categories.get(i);
            i++;
        }
        return null;
    }

    @Override
    public boolean update(Category category) {
        for (int i = 0; i< categories.size(); i++){
            if (categories.get(i).getId() == category.getId()){
                categories.set(i, category);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        int i=0;
        while (i< categories.size()){
            if (categories.get(i).getId()==id){
                categories.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}

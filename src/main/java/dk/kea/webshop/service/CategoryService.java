package dk.kea.webshop.service;

import dk.kea.webshop.model.Category;
import dk.kea.webshop.repository.CategoryRepository;
import dk.kea.webshop.repository.DBCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    DBCategoryRepository categoryRepository;

    public List<Category> readAll(){
        List<Category> categories = new ArrayList<>();
        for (Category category : categoryRepository.readAll()){
            categories.add(category);
        }

        return categories;
    }

    public void create(Category category){
        categoryRepository.create(category);
    }

    public boolean update(Category category){
        return categoryRepository.update(category);
    }

    public Category read(long id){
        return categoryRepository.read(id);
    }

    public boolean delete(long id){
        return categoryRepository.delete(id);
    }
}

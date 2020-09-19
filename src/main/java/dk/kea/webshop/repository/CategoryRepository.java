package dk.kea.webshop.repository;

import dk.kea.webshop.model.Category;
import dk.kea.webshop.util.ICrudRepository;

import java.util.List;

public class CategoryRepository implements ICrudRepository<Category> {

    @Override
    public void create(Category category) {

    }

    @Override
    public List<Category> readAll() {
        return null;
    }

    @Override
    public Category read(long id) {
        return null;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

package dk.kea.webshop.repository;

import dk.kea.webshop.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface ProductRepository extends CrudRepository<Product, Long> {



}

package dk.kea.webshop.service;

import dk.kea.webshop.model.Product;
import dk.kea.webshop.repository.DBProductRepository;
import dk.kea.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    DBProductRepository productRepository;

    public List<Product> readAll(){
        List<Product> products = new ArrayList<>();
        for (Product product : productRepository.readAll()){
            products.add(product);
        }

        return products;
    }

    public void create(Product product){
        productRepository.create(product);
    }

    public boolean update(Product product){
        return productRepository.update(product);
    }

    public Product read(long id){
        return productRepository.read(id);
    }

    public boolean delete(long id){
        return productRepository.delete(id);
    }

}

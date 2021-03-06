package dk.kea.webshop.repository;

import dk.kea.webshop.model.Product;
import dk.kea.webshop.util.ICrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    //collection for handling test data
    private List<Product> products = new ArrayList<>();

    public ProductRepository(){
        //fill in test data
        this.products.add(new Product(1, "Æg", "Kommer fra noget som kan lægge æg",32));
        this.products.add(new Product(2, "Mælk", "fra kokos måske?",12));
        this.products.add(new Product(3, "Ost", "fra en Kinesisk Panda",25));
    }

    @Override
    public List<Product> readAll(){
        return products;
    }

    @Override
    //add new animal to collection
    public void create(Product product){
        products.add(product);
    }

    @Override
    public Product read(long id) {
        //find element med id
        int i=0;
        while (i< products.size()){
            if (products.get(i).getId()==id)
                return products.get(i);
            i++;
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        //find element der skal opdateres i animals
        for (int i = 0; i< products.size(); i++){
            if (products.get(i).getId() == product.getId()){
                //opdater element (erstat med nye udgave)
                products.set(i, product);
                return true;
            }
        }
        //element med id ikke fundet
        return false;
    }

    @Override
    public boolean delete(long id) {
        //find og slet element med id
        int i=0;
        while (i< products.size()){
            if (products.get(i).getId()==id){
                products.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}

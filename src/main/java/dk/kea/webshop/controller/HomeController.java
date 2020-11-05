package dk.kea.webshop.controller;
import dk.kea.webshop.model.Product;
import dk.kea.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Controller
public class HomeController {

    ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String index()
    {
        ArrayList<Product> pList = new ArrayList<>();
        for (Product p : productRepository.findAll()){
            pList.add(p);
        }
        System.out.println(pList);
        return "index";
    }

}

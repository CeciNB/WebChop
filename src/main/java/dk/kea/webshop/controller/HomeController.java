package dk.kea.webshop.controller;

import dk.kea.webshop.model.Product;
import dk.kea.webshop.repository.CategoryRepository;
import dk.kea.webshop.repository.CompanyRepository;
import dk.kea.webshop.repository.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    CompanyRepository companyRepository;

    public HomeController(ProductRepository productRepository, CategoryRepository categoryRepository, CompanyRepository companyRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable("id") long id) {
        model.addAttribute("product", productRepository.findById(id));
        System.out.println(productRepository.findById(id));
        return "details";
    }

    @GetMapping("/create")
    public String create(Model modelCat, Model modelComp, Model model){
        modelCat.addAttribute("categories", categoryRepository.findAll());
        modelComp.addAttribute("companies", companyRepository.findAll());
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product){
        System.out.println(product);
        productRepository.save(product);
        return "redirect:/products";
    }
}

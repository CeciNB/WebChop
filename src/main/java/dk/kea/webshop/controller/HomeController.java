package dk.kea.webshop.controller;
import dk.kea.webshop.model.Product;
import dk.kea.webshop.service.CategoryService;
import dk.kea.webshop.service.CompanyDescriptionService;
import dk.kea.webshop.service.CompanyService;
import dk.kea.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyDescriptionService companyDescriptionService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model)
    {
        //add all products to view model from ProductService
        model.addAttribute("products", productService.readAll());
        return "products";
    }
    @GetMapping("/details/{id}")
    public String details(Model modela, Model modelb, Model modelc, Model modeld, @PathVariable("id") long id)
    {
        modela.addAttribute("product", productService.read(id));
        modelb.addAttribute("company", companyService.read(id));
        modelc.addAttribute("companyDescription", companyDescriptionService.read(id));
        modeld.addAttribute("category", categoryService.read(id));
        return "details";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product){
        productService.create(product);
        return "redirect:/";
    }

    //use pathvariable to map id from list on web page
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        //tilføj Product med id til model view
        model.addAttribute("product", productService.read(id));
        return "update";
    }

    //update product
    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        //update by using update service
        productService.update(product);
        return "redirect:/";
    }

    //delete animal
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        /* if (productService.delete(id))
            model.addAttribute("status", "element " + id + " slettet";
            else
            model.addAttribute("status", "element " + id + " kunne ikke slettes!";
         */
        productService.delete(id);
        //burde fange returværdi fra kald og sende statusbesked med ud på websiden
        //model.addAttribute("status", returnværdi af kald)
        return "redirect:/";
    }
}

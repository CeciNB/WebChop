package dk.kea.webshop.controller;

import dk.kea.webshop.model.Product;
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

    @GetMapping("/")
    public String index(Model model)
    {
        //add all products to view model from ProductService
        model.addAttribute("products", productService.readAll());
        return("index");
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

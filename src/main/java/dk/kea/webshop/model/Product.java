package dk.kea.webshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "price")
    private Double price;

    @ManyToOne
    private Company company;

    @ManyToMany
    private Set<Category> categories;

    @OneToOne
    private CompanyDescription companyDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> category) {
        this.categories = category;
    }

    public CompanyDescription getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(CompanyDescription companyDescription) {
        this.companyDescription = companyDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", company=" + company +
                ", category=" + categories +
                ", companyDescription=" + companyDescription +
                '}';
    }
}

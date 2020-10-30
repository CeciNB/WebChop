package dk.kea.webshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyDescription {
    @Id
    private long id;
    private String name;
    private long productId;

    public CompanyDescription() {
    }

    public CompanyDescription(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyDescription(long id, String name, long productId) {
        this.id = id;
        this.name = name;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}

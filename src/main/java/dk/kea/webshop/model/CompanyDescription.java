package dk.kea.webshop.model;

import javax.persistence.*;

@Entity
@Table (name = "company_descriptions")
public class CompanyDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "description")
    private String description;

    @OneToOne
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CompanyDescription{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

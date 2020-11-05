package dk.kea.webshop.model;
import javax.persistence.*;

@Entity
public class CompanyDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToOne
    private Product product;


}

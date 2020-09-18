package dk.kea.webshop.model;

public class Product {

    private long id;
    private String name;
    private String species;

    public Product() {
    }

    public Product(long id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

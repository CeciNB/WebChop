package dk.kea.webshop.model;

public class CompanyDescription {
    private long id;
    private String name;

    public CompanyDescription() {
    }

    public CompanyDescription(long id, String name) {
        this.id = id;
        this.name = name;
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
}

package dk.kea.webshop.service;

import dk.kea.webshop.model.Product;
import dk.kea.webshop.repository.DBProductRepository;
import dk.kea.webshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    static final long ID = 1234;
    static final Product p1 = new Product(1, "Æg", "Kommer fra noget som kan lægge æg",32);
    static final Product p2 = new Product(2, "Mælk", "fra kokos måske?",12);
    static final Product p3 = new Product(3, "Ost", "fra en Kinesisk Panda",25);

    @InjectMocks
    ProductService productService;

    @Mock
    DBProductRepository mockProductRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void readAll() {
        ArrayList<Product> prodList = new ArrayList<>();

        prodList.add(p1);
        prodList.add(p2);
        prodList.add(p3);

        Mockito.when(mockProductRepository.readAll()).thenReturn(prodList);

        assertEquals("Æg",productService.readAll().get(0).getName());

        Mockito.verify(mockProductRepository, Mockito.times(1)).readAll();
    }

    @Test
    void create() {

    }

    @Test
    void update() {
    }

    @Test
    void read() {

        Product product = new Product(ID, "name","description", 200);

        Mockito.when(mockProductRepository.read(ID)).thenReturn(product);

        assertEquals("name",productService.read(ID).getName());

        Mockito.verify(mockProductRepository, Mockito.times(1)).read(ID);

    }

    @Test
    void delete() {

        Mockito.when(mockProductRepository.delete(ID)).thenReturn(true);

        assertEquals(true, productService.delete(ID));
    }
}
package dk.kea.webshop.service;

import dk.kea.webshop.model.Product;
import dk.kea.webshop.repository.DBProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class ProductServiceTest2 {

    DBProductRepository mockRepository;

    ProductService2 productService;


    @BeforeEach
    void setUp() {
        mockRepository = Mockito.mock(DBProductRepository.class);

        productService = new ProductService2(mockRepository);
    }

    @Test
    void readAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }

}
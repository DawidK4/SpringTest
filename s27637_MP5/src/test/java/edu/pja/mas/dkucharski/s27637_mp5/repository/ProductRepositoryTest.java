package edu.pja.mas.dkucharski.s27637_mp5.repository;

import edu.pja.mas.dkucharski.s27637_mp5.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Product p1;

    @BeforeEach
    public void initData() {
        // id is assigned automatically so there is no need to add it
        p1 = Product.builder()
                .name("p1")
                .price(100.0d)
                .quantity(2L)
                .build();
    }

    @Test
    public void testRequiredDependencies(){
        assertNotNull(productRepository);
    }

    @Test
    public void testFetchProducts(){
        Iterable<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void testSaveProduct(){
        productRepository.save(p1);
        entityManager.flush();
        long count = productRepository.count();
        assertEquals(1, count);
    }

    @Test
    public void testSaveInvalidProductByName(){
        assertThrows(ConstraintViolationException.class, () -> {
            p1.setName(" ");
            productRepository.save(p1);
            entityManager.flush();
        });
    }

    // To be fixed
    @Test
    public void testFindProductByName(){
        List<Product> products = productRepository.findByName(p1.getName());
        System.out.println(products);
        assertEquals(1, products.size());
    }

    // To be fixed
    @Test
    public void testFindProductByPrice(){
        List<Product> res = productRepository.findProductsWithPriceGreaterThan(100.00);
        System.out.println(res);
        assertEquals(0, res.size());
    }
}

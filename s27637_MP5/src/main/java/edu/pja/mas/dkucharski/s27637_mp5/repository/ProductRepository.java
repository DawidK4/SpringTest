package edu.pja.mas.dkucharski.s27637_mp5.repository;

import edu.pja.mas.dkucharski.s27637_mp5.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findByName(String name);

    @Query("from Product p where p.price > :minPrice")
    public List<Product> findProductsWithPriceGreaterThan(@Param("minPrice") Double price);
}

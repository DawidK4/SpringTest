package edu.pja.mas.dkucharski.s27637_mp5;

import edu.pja.mas.dkucharski.s27637_mp5.model.Product;
import edu.pja.mas.dkucharski.s27637_mp5.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;

    // Here the data ought to be initialized
    @EventListener
    public void atStart(ContextRefreshedEvent event) {
//        System.out.println("Initializing Data");
//        Iterable<Product> products = productRepository.findAll();
//        System.out.println(products);
    }
}

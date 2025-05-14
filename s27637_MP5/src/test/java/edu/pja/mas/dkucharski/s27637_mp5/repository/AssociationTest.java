package edu.pja.mas.dkucharski.s27637_mp5.repository;

import edu.pja.mas.dkucharski.s27637_mp5.model.Customer;
import edu.pja.mas.dkucharski.s27637_mp5.model.Order;
import edu.pja.mas.dkucharski.s27637_mp5.model.OrderStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AssociationTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager em;

    Customer c1;
    Order o1;

    @Test
    public void testRequiredDependencies() {
        assertNotNull(customerRepository);
        assertNotNull(orderRepository);
    }

    @BeforeEach
    public void initData() {
        c1 = Customer.builder()
                .address("address")
                .passwordHash("hash")
                .email("mail")
                .build();

        o1 = Order.builder()
                .status(OrderStatus.PENDING)
                .orderDate(LocalDate.now())
                .build();
    }

    @Test
    public void testSave() {
        c1.getOrders().add(o1);
        customerRepository.save(c1);
        o1.setIsPlacedBy(c1);
        orderRepository.save(o1);

        Optional<Order> byId = orderRepository.findById(o1.getId());
        assertTrue(byId.isPresent());
        System.out.println(byId.get().getIsPlacedBy());
        assertEquals(1,byId.get().getIsPlacedBy().getOrders().size());
    }
}

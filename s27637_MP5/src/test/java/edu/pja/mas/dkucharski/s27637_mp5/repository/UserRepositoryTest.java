package edu.pja.mas.dkucharski.s27637_mp5.repository;

import edu.pja.mas.dkucharski.s27637_mp5.model.Customer;
import edu.pja.mas.dkucharski.s27637_mp5.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager em;

    Employee e1, e2;
    Customer c1;

    @BeforeEach
    public void setUp() {
        e1 = Employee.builder()
                .email("MAIL")
                .passwordHash("hash")
                .position("position")
                .build();

        e2 = Employee.builder()
                .email("Mail")
                .passwordHash("HASH")
                .position("position")
                .build();

        c1 = Customer.builder()
                .email("mail")
                .passwordHash("hash")
                .address("asdasda")
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(userRepository);
        assertNotNull(employeeRepository);
        assertNotNull(customerRepository);
    }

    @Test
    public void testSaveAll() {
        employeeRepository.saveAll(Arrays.asList(e1, e2));
        customerRepository.save(c1);
        em.flush();

        assertEquals(2, employeeRepository.count());
    }
}
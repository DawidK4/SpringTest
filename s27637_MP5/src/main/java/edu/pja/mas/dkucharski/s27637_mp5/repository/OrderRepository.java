package edu.pja.mas.dkucharski.s27637_mp5.repository;

import edu.pja.mas.dkucharski.s27637_mp5.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

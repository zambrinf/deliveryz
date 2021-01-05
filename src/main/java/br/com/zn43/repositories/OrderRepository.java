package br.com.zn43.repositories;

import br.com.zn43.entities.Order;
import br.com.zn43.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT DISTINCT orderobj FROM Order orderobj " +
            "JOIN FETCH orderobj.products products " +
            "WHERE orderobj.status = :status " +
            "ORDER BY orderobj.moment ASC")
    List<Order> findPendingOrdersWithProducts(OrderStatus status);
}

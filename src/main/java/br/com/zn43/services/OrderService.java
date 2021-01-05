package br.com.zn43.services;

import br.com.zn43.dto.OrderDTO;
import br.com.zn43.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.zn43.entities.OrderStatus.PENDING;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findPendingOrdersWithProducts() {
        return orderRepository.findPendingOrdersWithProducts(PENDING)
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

}

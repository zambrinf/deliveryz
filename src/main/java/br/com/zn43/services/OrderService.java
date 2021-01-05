package br.com.zn43.services;

import br.com.zn43.dto.OrderDTO;
import br.com.zn43.dto.ProductDTO;
import br.com.zn43.dto.ProductUtil;
import br.com.zn43.entities.Order;
import br.com.zn43.entities.OrderStatus;
import br.com.zn43.entities.Product;
import br.com.zn43.repositories.OrderRepository;
import br.com.zn43.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.zn43.entities.OrderStatus.PENDING;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

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

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        Set<Product> products = orderDTO.getProducts()
                .stream()
                .map(productDTO -> productRepository.getOne(productDTO.getId()))
                .collect(Collectors.toSet());
        Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(), Instant.now(), PENDING, products);
        Order savedOrder = orderRepository.save(order);
        return new OrderDTO(savedOrder);
    }

}

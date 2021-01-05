package br.com.zn43.controllers;

import br.com.zn43.dto.OrderDTO;
import br.com.zn43.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders", produces = "application/json")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    @ResponseBody
    public List<OrderDTO> findPendingOrdersWithProducts() {
        return orderService.findPendingOrdersWithProducts();
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO orderDTO) {
        OrderDTO insertedOrder = orderService.insert(orderDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(insertedOrder.getId())
                .toUri();
        return ResponseEntity.created(uri).body(insertedOrder);
    }

    @PutMapping("/{id}/delivered")
    @ResponseBody
    public OrderDTO setDelivered(@PathVariable Long id) {
        return orderService.setDelivered(id);
    }

}

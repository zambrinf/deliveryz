package br.com.zn43.controllers;

import br.com.zn43.dto.OrderDTO;
import br.com.zn43.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}

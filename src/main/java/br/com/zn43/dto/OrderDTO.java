package br.com.zn43.dto;

import br.com.zn43.entities.Order;
import br.com.zn43.entities.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;
    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO(Order order) {
        id = order.getId();
        address = order.getAddress();
        latitude = order.getLatitude();
        longitude = order.getLongitude();
        moment = order.getMoment();
        status = order.getStatus();
        products = ProductUtil.toProductDTO(order.getProducts());
    }

}

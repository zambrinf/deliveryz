package br.com.zn43.dto;

import br.com.zn43.entities.Product;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductUtil {

    public static List<ProductDTO> toProductDTO(Collection<Product> collection) {
        return collection.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

}

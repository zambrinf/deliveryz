package br.com.zn43.dto;

import br.com.zn43.entities.Product;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductUtil {

    public static List<ProductDTO> toProductDTO(Collection<Product> collection) {
        return collection.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public static Set<ProductDTO> toSetProductDTO(Collection<Product> collection) {
        return collection.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toSet());
    }

    public static List<Long> toIdsFromProductDTO(Collection<ProductDTO> collection) {
        return collection.stream()
                .map(ProductDTO::getId)
                .collect(Collectors.toList());
    }

}

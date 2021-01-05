package br.com.zn43.services;

import br.com.zn43.dto.ProductDTO;
import br.com.zn43.dto.ProductUtil;
import br.com.zn43.entities.Product;
import br.com.zn43.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = productRepository.findAllByOrderByNameAsc();
        return ProductUtil.toProductDTO(list);
    }

    @Transactional(readOnly = true)
    public Set<Product> findAllFromDTO(Collection<ProductDTO> productsDTOS) {
        List<Long> productsIds = ProductUtil.toIdsFromProductDTO(productsDTOS);
        return new HashSet<>(productRepository.findAllById(productsIds));
    }

}

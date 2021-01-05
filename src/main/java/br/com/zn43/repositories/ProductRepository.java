package br.com.zn43.repositories;

import br.com.zn43.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

   List<Product> findAllByOrderByNameAsc();

}

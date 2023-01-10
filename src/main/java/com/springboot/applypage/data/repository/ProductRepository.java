package com.springboot.applypage.data.repository;
import com.springboot.applypage.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

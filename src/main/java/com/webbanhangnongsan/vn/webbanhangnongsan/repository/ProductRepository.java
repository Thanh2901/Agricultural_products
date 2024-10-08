package com.webbanhangnongsan.vn.webbanhangnongsan.repository;

import com.webbanhangnongsan.vn.webbanhangnongsan.dto.ProductResponse;
import com.webbanhangnongsan.vn.webbanhangnongsan.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM products LIMIT 8", nativeQuery = true)
    List<Product> getTop8Products();
}

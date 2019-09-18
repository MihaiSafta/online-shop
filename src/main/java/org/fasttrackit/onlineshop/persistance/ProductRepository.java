package org.fasttrackit.onlineshop.persistance;

import org.fasttrackit.onlineshop.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByNameContaining(String partialName, Pageable pageable);

    Page<Product> findByNameContainingAndQuantityGreaterThanEqual(String partialName, Pageable pageable, int minimumQuantity);
    //jpql syntax, java persistence query language
    //named query
    @Query("SELECT product FROM Product product WHERE name LIKE ':partialName'")
    List<Product>  findByPartialName(String partialName);

}

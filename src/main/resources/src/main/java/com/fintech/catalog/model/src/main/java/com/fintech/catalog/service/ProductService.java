package com.fintech.catalog.service;

import com.fintech.catalog.model.Product;
import com.fintech.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // This method checks Redis first. If found, it returns without hitting MySQL.
    @Cacheable(value = "products", key = "#id")
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // This ensures that when a product is updated, the old data is deleted from Redis.
    @CacheEvict(value = "products", key = "#product.id")
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}

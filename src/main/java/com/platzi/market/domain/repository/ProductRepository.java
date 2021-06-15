package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> getProductById(int productId);
    Optional<List<Product>> getByCategoy(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    //Optional<List<Product>> getPriceThanTo(double price);
    Product save(Product product);
    void delete(int productId);
}

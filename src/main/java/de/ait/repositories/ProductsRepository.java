package de.ait.repositories;

import de.ait.models.Product;

import java.util.List;

public interface ProductsRepository {
    public void save(Product product);
    public List<Product> getAllProducts();
}

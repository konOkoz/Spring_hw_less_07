package de.ait.services;

import de.ait.models.Product;

import java.util.List;

public interface ProductsService {
    public void saveProduct(String name, Integer count);
    public List<Product> getAllProducts();
}

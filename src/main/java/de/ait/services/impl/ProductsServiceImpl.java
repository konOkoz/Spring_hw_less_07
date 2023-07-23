package de.ait.services.impl;

import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;
import de.ait.services.ProductsService;
import de.ait.validators.CountValidator;
import de.ait.validators.NameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    private final NameValidator nameValidator;

    private final CountValidator countValidator;


    @Override
    public void saveProduct(String name, Integer count) {

        nameValidator.validateName(name);

        countValidator.validateCount(count);

        Product product = new Product(name, count);

        productsRepository.save(product);

    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.getAllProducts();
    }
}

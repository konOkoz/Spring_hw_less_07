package de.ait.repositories.impl;

import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class ProductsRepositoryFileImpl implements ProductsRepository {

    private final String fileName;

    public ProductsRepositoryFileImpl(@Value("${file.name}") String fileName){
        this.fileName = fileName;
    }
    public void save(Product product){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(product.getName() + "#" + product.getCount() + "\n");
        }catch(IOException e){
            throw new IllegalArgumentException("File problems");
        }
    }
    public List<Product> getAllProducts(){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(line -> line.split("#"))
                    .map(array -> new Product(array[0], Integer.parseInt(array[1])))
            .collect(Collectors.toList());
        } catch (IOException e){
            throw new IllegalArgumentException("File problems");
        }
    }
}

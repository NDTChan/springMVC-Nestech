package com.nestech.springmvcnestech.service;

import com.nestech.springmvcnestech.model.Product;
import com.nestech.springmvcnestech.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product) {
        if (product.getNumber() > 1 && !productRepository.isDuplicateId(product.getId())) {
            productRepository.save(product);
        }
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void delete(int id) {
        productRepository.delete(id);
    }

    public Product getById(int id) {
        return productRepository.getById(id);
    }

    public void update(int id, String name, int number) {
        productRepository.update(id, name, number);
    }
}

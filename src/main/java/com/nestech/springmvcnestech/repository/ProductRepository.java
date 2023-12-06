package com.nestech.springmvcnestech.repository;

import com.nestech.springmvcnestech.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Chăn", 10));
        productList.add(new Product(2, "Gối", 5));
        productList.add(new Product(3, "Đệm", 11));
    }

    public void save(Product product) {
        productList.add(product);
    }

    public List<Product> getAll() {
        return productList;
    }

    public boolean isDuplicateId(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void delete(int id) {
        productList.removeIf(obj -> obj.getId() == id);
    }

    public Product getById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void update(int id, String name, int number) {
        Product presentProduct = getById(id);
        presentProduct.setName(name);
        presentProduct.setNumber(number);

        // productEntity.update(presentProduct);

        for (Product productInDB : productList) {
            if (productInDB.getId() == presentProduct.getId()) {
                productInDB.setName(presentProduct.getName());
                productInDB.setNumber(presentProduct.getNumber());
            }
        }
    }
}

package com.nykaa.wishlist.service;

import com.nykaa.wishlist.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProductList();
    Product saveProduct(Product product);
    Product getProductById(String id);
    Product updateProduct(String id,Product product);
    void deleteProduct(String id);
}

/*

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    List <Product> getProductList(){

        return productRepository.findAll();
    };*/

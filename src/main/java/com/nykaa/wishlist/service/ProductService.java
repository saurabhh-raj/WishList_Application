package com.nykaa.wishlist.service;

import com.nykaa.wishlist.model.Product;

import java.util.List;

public interface ProductService {
//    static List<Product> queryForRecords(String id, String pID) {
//    }

    List<Product> getProductList(String userBucketId , String tokenUsername);
    String saveProduct(Product product  );
    List<Product> getProductById(String id  , String pId );
    Product updateProduct(String id,Product product , String pId);
    String deleteProduct(String id , String pId ,String tokenUsername);
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

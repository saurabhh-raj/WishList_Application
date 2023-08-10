package com.nykaa.wishlist.service;

import com.nykaa.wishlist.model.Product;
import com.nykaa.wishlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository;

    @Override
    public List<Product> getProductList( String userBucketId) {

        return (List<Product>) productRepository.findAll( userBucketId);
    }



    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String id , String Pid) {
        return productRepository.findById(id , Pid);
         }


//        orElseThrow(() -> new ResourceNotFoundException("Product Not Found"+id));


    @Override
    public Product updateProduct(String id, Product product , String pId) {
        productRepository.findById(id , pId);
//                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"+id));
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id , String pId) {
        productRepository.findById(id , pId);
//                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found :"+id));
        productRepository.deleteById(id);
    }
}

package com.nykaa.wishlist.service;

import com.nykaa.wishlist.model.Product;
import com.nykaa.wishlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository;

    @Override
    public List<Product> getProductList( String userBucketId) {

        return (List<Product>) productRepository.findAll( userBucketId);
    }



    @Override
    public String saveProduct(Product product ) {

        return (String)productRepository.save(product  );
    }

//    @Override
    public List<Product> getProductById(String id , String Pid ) {
        return (List<Product>)productRepository.findById(id , Pid );
         }


//        orElseThrow(() -> new ResourceNotFoundException("Product Not Found"+id));


    @Override
    public Product updateProduct(String id, Product product , String pId) {
        productRepository.findById(id , pId);
        return null;
//                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"+id));
       // return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String wid , String pid) {
        productRepository.findById(wid , pid);
//                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found :"+id));
        productRepository.deleteById(wid , pid);
    }
}

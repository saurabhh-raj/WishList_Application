package com.nykaa.wishlist.service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
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
    public String deleteProduct(String wid , String pid) {
        List <Product> prod = (List <Product>) productRepository.findById(wid , pid);
        if( prod.size() == 0)throw new ResourceNotFoundException("Product Not Found :"+ wid );
       else{
           productRepository.findById(wid , pid);
           productRepository.deleteById(wid , pid);
           return "Product " + "with id : " + pid + " deleted from Wishlist " + wid;}
    }
}

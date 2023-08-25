package com.nykaa.wishlist.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.nykaa.wishlist.model.Product;
import com.nykaa.wishlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository;

    @Override
    public List<String> getWishlists(String tokenUsername) {

        return productRepository.findWishlistsByUsername(tokenUsername);

    }

    @Override
    public List<Product> getProductList( String userBucketId ,  String tokenUsername) {

          List<Product> productsFromDynamoDB =  productRepository.findAll( userBucketId);
          if(productsFromDynamoDB.get(0).getCustomer().equals(tokenUsername)) {return productsFromDynamoDB;}
          else return null;
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
    public String deleteProduct(String wid , String pid , String tokenUsername) {
        List <Product> prod = (List <Product>) productRepository.findById(wid , pid);
        if( prod.size() == 0)throw new ResourceNotFoundException("Product Not Found :"+ wid );
       else {

            if (prod.get(0).getCustomer().equals(tokenUsername)) {
                productRepository.findById(wid, pid);
                productRepository.deleteById(wid, pid);
                return "Product " + "with id : " + pid + " deleted from Wishlist " + wid;
            } else return "invalid request , User denied";
        }
    }
}

package com.nykaa.wishlist.controller;

import com.nykaa.wishlist.WishlistApplication;
import com.nykaa.wishlist.model.Product;
import com.nykaa.wishlist.model.TestProduct;
import com.nykaa.wishlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping("/product/{userBucketId}")
    public ResponseEntity<Product> getProductById(@PathVariable String userBucketId){
      /*  List<Wishlist> body = productService.getProductById(userBucketId);
        List<ProductDto> products = new ArrayList<ProductDto>();
        for (WishList wishList : body) {
            products.add(ProductService.getDtoFromProduct(wishList.getProduct()));
        }

        return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);*/
        return ResponseEntity.ok(productService.getProductById(userBucketId));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductList(){
        return ResponseEntity.ok(productService.getProductList());
    }
    /*  @PutMapping("/product/{userBucketId}")
      public ResponseEntity<Product> updateProduct(@PathVariable String id,@RequestBody Product product){
          return ResponseEntity.ok(productService.updateProduct(id,product));
      }*/
    @DeleteMapping("/product/{userBucketId}")
    public void deleteProductById(@PathVariable String id){
        productService.deleteProduct(id);
    }
}

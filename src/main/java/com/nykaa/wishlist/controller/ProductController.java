package com.nykaa.wishlist.controller;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.nykaa.wishlist.Util.JwtUtil;
import com.nykaa.wishlist.WishlistApplication;
import com.nykaa.wishlist.exception.ResourceNotFoundException;
import com.nykaa.wishlist.model.Product;
import com.nykaa.wishlist.model.User;

import com.nykaa.wishlist.repository.ProductRepository;
import com.nykaa.wishlist.repository.UserRepository;
import com.nykaa.wishlist.service.ProductService;
import com.nykaa.wishlist.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class  ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }

    @PostMapping("/product")
    @ResponseBody
    public ResponseEntity<String> saveProduct(@RequestBody @Valid Product product , @RequestHeader("Authorization") String Authorization){
       // product.setUserBucketId(product.getUserBucketId(), product.getCustomerId());
        //product.getCustomerId()+ product.getUserBucketId()
       String token = Authorization.substring(7);
        String userName = jwtUtil.extractUsername(token);
        product.setCustomer(userName);
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping("/product")
    public ResponseEntity< List<Product>> getProductById( @RequestParam String userBucketId , String pId ){
      /*  List<Wishlist> body = productService.getProductById(userBucketId);
        List<ProductDto> products = new ArrayList<ProductDto>();
        for (WishList wishList : body) {
            products.add(ProductService.getDtoFromProduct(wishList.getProduct()));
        }

        return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);//////aftrer this uncoment*/
//        List<Product> products = new ArrayList<Product>();
//        for (int i=0;i<3;i++){
//            products.add(productService.getProductById(userBucketId , pId));
//        }
//        return new ResponseEntity< List<Product>>((List<Product>) products, HttpStatus.OK);
//        return ResponseEntity.ok(Collections.singletonList(productService.getProductById(userBucketId, pId)));
        return ResponseEntity.ok((List<Product>) productService.getProductById(userBucketId , pId));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductList(@RequestParam String userBucketId , @RequestHeader("Authorization") String Authorization){
        String token = Authorization.substring(7);
        String userName = jwtUtil.extractUsername(token);
        System.out.println("ptinr");
        return ResponseEntity.ok(productService.getProductList(userBucketId , userName));
    }
    /*  @PutMapping("/product/{userBucketId}")
      public ResponseEntity<Product> updateProduct(@PathVariable String id,@RequestBody Product product){
          return ResponseEntity.ok(productService.updateProduct(id,product));
      }*/
    @DeleteMapping("/product")

    public String deleteProductById(@RequestParam String wid ,  String pid , @RequestHeader("Authorization") String Authorization){
        String token = Authorization.substring(7);
        String tokenUsername = jwtUtil.extractUsername(token);

        return productService.deleteProduct(wid , pid , tokenUsername);
    }

   @PostMapping("/signup")

    public String Signup(@RequestBody User user) throws ResourceNotFoundException {
        return userService.createUser(user);

    }
    @PostMapping("/signin")    //ResponseEntity<String>
        public String login(@RequestBody User user) {

        return userService.loginUser(user);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody User authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }


}

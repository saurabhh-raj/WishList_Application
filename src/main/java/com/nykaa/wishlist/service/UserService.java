//
//
//import com.nykaa.wishlist.model.Product;
//import com.nykaa.wishlist.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.nykaa.wishlist.service.UserService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//     ProductRepository productRepository;
//
//
//    public  String registerUser(Product product) {
//        if (productRepository.findByUsername(product.getCustomer())  != null) {
//  return "Username already exists.";
//        }
//
//        Product user = new Product(product.getUserBucketId(), product.getProductId(), product.getCustomer(), product.getPrice(), "usercreated");
//        user.setCustomer(product.getCustomer());
//        user.setPrice(product.getPrice()); // Use BCryptPasswordEncoder
//
//        return productRepository.save(user);
//    }
//
//
//}
package com.nykaa.wishlist.service;
import com.nykaa.wishlist.Util.JwtUtil;
import com.nykaa.wishlist.model.User;
import com.nykaa.wishlist.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class UserService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;


/*
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
*/

    public String createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return " user already present";
        } else {
            user.setPassword(user.getPassword());
            userRepository.save(user);
            return user.getUsername() + " user registered";
        }
    }


    public String loginUser(User user) {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            User userFromDb = userRepository.findByUsername(user.getUsername());
            String pdb = userFromDb.getPassword();
            String pus = user.getPassword();
            //  Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (pus.equals(pdb)) {
//                final String token = jwtTokenUtil.generateToken(user);
//
//                return ResponseEntity.ok(new JwtResponse(token));
                return "login success";
            } else {
                return "password Not Match";
            }
        } else {
            return "User not exits";

        }
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword() , new ArrayList<>());

    }


}
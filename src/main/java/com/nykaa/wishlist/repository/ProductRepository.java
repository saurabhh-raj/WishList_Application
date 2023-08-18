package com.nykaa.wishlist.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nykaa.wishlist.model.Product;

//import jdk.javadoc.internal.doclets.formats.html.Table;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;


@Repository
/*
public interface ProductRepository extends DynamoDBCrudRepository<Product,String> {
}*/



@EnableScan



public class ProductRepository {


    @Autowired
    private  DynamoDBMapper dynamoDBMapper;

    public String save(Product product) {
  /*     Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val", new AttributeValue().withS(id));
     //   eav.put(":val2", new AttributeValue().withS(pID));


         //DynamoDBQueryExpression<Product> queryExpression = new DynamoDBQueryExpression<Product>()
                DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userBucketId = :val")
                .withExpressionAttributeValues(eav);

        List<Product> productsFromDynamoDB = dynamoDBMapper.scan(Product.class, scanExpression);

        List<Product> productDTOs = productsFromDynamoDB.stream()
                .map(product1 -> new Product(product1.getUserBucketId(), product1.getProductId(), product1.getName(), product1.getPrice() , product1.getQuantity()))
                .collect(Collectors.toList());

        productDTOs.add(product);
        for(Product x : productDTOs)*/
        dynamoDBMapper.save(product);
        return  "Product " + product.getName() + " added to :"+ product.getCustomer()+ " 's Wishlist : " + product.getUserBucketId() +"or User"+ product.getCustomer()+ "Created";

      /*   List<Product> productsFromDynamoDB =  Collections.singletonList(dynamoDBMapper.load(Product.class, id, pID));
        List<Product> productDTOs = productsFromDynamoDB.stream()
                .map(product1 -> new Product(product1.getUserBucketId(), product1.getProductId(), product1.getName(), product1.getPrice() , product1.getQuantity()))
                .collect(Collectors.toList());
        productDTOs.add(product);
        return productDTOs;
*/
       /*  dynamoDBMapper.batchSave(product);
        return (List<Product>) product;*/
    }

    public List <Product> findById(String id , String pID ) {
 /*       List<Product> records = ProductService.queryForRecords(id, pID);
        return ResponseEntity.ok(records);*/
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(id));
        eav.put(":val2", new AttributeValue().withS(pID));


       //  DynamoDBQueryExpression<Product> queryExpression = new DynamoDBQueryExpression<Product>()
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userBucketId = :val1 AND productId = :val2")
                .withExpressionAttributeValues(eav);

        List<Product> productsFromDynamoDB = dynamoDBMapper.scan(Product.class, scanExpression);
   return productsFromDynamoDB;
        //  return dynamoDBMapper.load(Product.class, id , pID  );
    }
    public List<Product> findAll( String userBucketId)  {
       // return null;
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userBucketId = :val")
                .withExpressionAttributeValues(Collections.singletonMap(":val", new AttributeValue(userBucketId)));


        return dynamoDBMapper.scan(Product.class, scanExpression);
        //return dynamoDBMapper.scan( Product.class, userBucketId));
    }

    public void deleteById(String wid , String pid) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Product.class, wid ,pid));

    }
    public  Product findByUsername(String customer) {
//        Product p =  ;

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("customer = :val")
                .withExpressionAttributeValues(Collections.singletonMap(":val", new AttributeValue(customer)));


    PaginatedScanList<Product> x = dynamoDBMapper.scan(Product.class, scanExpression);
        if(x== null)return null;
        else return  x.get(0);
    }



/*  public String updateCustomer(String customerId, Product customer) {
        dynamoDBMapper.save(customer,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("customerId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(customerId)
                                )));
        return customerId;
    }
*/


}







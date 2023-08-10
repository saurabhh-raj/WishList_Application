package com.nykaa.wishlist.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.nykaa.wishlist.model.Product;
import com.nykaa.wishlist.model.TestProduct;
import com.nykaa.wishlist.repository.ProductRepository;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
/*
public interface ProductRepository extends DynamoDBCrudRepository<Product,String> {
}*/



@EnableScan



public class ProductRepository {


    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Product save(Product product) {
        dynamoDBMapper.batchSave(product);
        return product;
    }

    public Product findById(String id , String pID) {
        return dynamoDBMapper.load(Product.class, id , pID );
    }
    public List<Product> findAll( String userBucketId)  {
       // return null;
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userBucketId = :val")
                .withExpressionAttributeValues(Collections.singletonMap(":val", new AttributeValue(userBucketId)));

        return dynamoDBMapper.scan(Product.class, scanExpression);
        //return dynamoDBMapper.scan( Product.class, userBucketId));
    }

    public void deleteById(String customerId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Product.class, customerId));

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







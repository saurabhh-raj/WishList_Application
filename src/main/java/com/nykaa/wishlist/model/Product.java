package com.nykaa.wishlist.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@DynamoDBTable(tableName = "bucketProductStore")
@Data
public class Product {

    public Product() {

    }



    @DynamoDBAttribute(attributeName = "userBucketId")
    @DynamoDBHashKey(attributeName = "userBucketId" )
    private String userBucketId ;



    public String getUserBucketId() {
        return userBucketId;
    }




    public Product( String userBucketId, String productId, String customer, String price, String name) {
        this.userBucketId =  customer + "_" + userBucketId;
        this.productId = productId;
        this.customer = customer;
        this.price = price;
        this.name = name;
    }







    public void setUserBucketId(String userBucketId  ) {
        this.userBucketId =   userBucketId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @DynamoDBAttribute(attributeName = "productId")
    @DynamoDBRangeKey(attributeName = "productId" )
    private String productId;

    //@DynamoDBRangeKey(attributeName = "quantity")
    @DynamoDBAttribute(attributeName = "customer")
    private String customer;

    public String getCustomer() {
        return customer;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @DynamoDBAttribute(attributeName = "price")
    private String price;

    @DynamoDBAttribute(attributeName = "name")
    private String name;


}



 /*   @DynamoDBAttribute(attributeName = "price")
    private float price;*/




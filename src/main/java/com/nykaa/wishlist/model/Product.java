package com.nykaa.wishlist.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import lombok.Data;

@DynamoDBTable(tableName = "bucketProductStore")
@Data
public class Product {

    @DynamoDBAttribute(attributeName = "userBucketId")
    @DynamoDBHashKey(attributeName = "userBucketId")
    private String userBucketId;

    @DynamoDBAttribute(attributeName = "productId")
    @DynamoDBRangeKey(attributeName = "productId")
    private String productId;

   // @DynamoDBRangeKey(attributeName = "quantity")
    @DynamoDBAttribute(attributeName = "quantity")
    private String quantity;

    @DynamoDBAttribute(attributeName = "price")
    private String price;

    @DynamoDBAttribute(attributeName = "name")
    private String name;


}



 /*   @DynamoDBAttribute(attributeName = "price")
    private float price;*/




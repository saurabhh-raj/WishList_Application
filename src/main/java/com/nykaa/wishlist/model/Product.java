package com.nykaa.wishlist.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "bucketProductStore") // validates if the DynamoDB table exists or not.DynamoDB does not create collection automatically so it is important to create dynamodb before hand

@Data
public class Product {

   @DynamoDBHashKey(attributeName = "userBucketId") //marking a property as the hash key for a modeled class
//   @DynamoDBAutoGeneratedKey              //for making the hashkey property to autogenerate the key & it supports String type only
    private String userBucketId;

    @DynamoDBHashKey(attributeName = "productId") //Maps a property to dynamodb table attribute.
    private String productId;

   @DynamoDBAttribute(attributeName = "quantity")
    private String quantity;

    @DynamoDBAttribute(attributeName = "price")
    private String price;

    @DynamoDBAttribute(attributeName = "name")
    private String name;


}



 /*   @DynamoDBAttribute(attributeName = "price")
    private float price;*/




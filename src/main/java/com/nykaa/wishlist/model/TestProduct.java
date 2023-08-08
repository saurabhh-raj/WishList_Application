package com.nykaa.wishlist.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.Data;

@Data
public class TestProduct {
    private String userBucketId;

    private String productId;

    private String quantity;

}


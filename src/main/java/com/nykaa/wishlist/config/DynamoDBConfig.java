package com.nykaa.wishlist.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
//@ComponentScan(basePackages = {"com.easy2excel.springbootawsdynamodbcrud.repository.ProductRepository"})
@EnableDynamoDBRepositories(basePackages = {"com.nykaa.wishlist.repository.ProductRepository"})
public class DynamoDBConfig {

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }
    private AmazonDynamoDB buildAmazonDynamoDB() {
        AWSCredentialsProvider credentialsProvider = new DefaultAWSCredentialsProviderChain();

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.ap-south-1.amazonaws.com", "ap-south-1"))
                .withCredentials(credentialsProvider)
                .build();
    }
   /* BasicAWSCredentials awsCreds = new BasicAWSCredentials("accessKey", "secretKey");
    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion("region_name_here").build();
    S3Object object = s3Client.getObject(new GetObjectRequest("bucketName", "key"));
    BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));

    String s = null;
    while((s = reader.readLine()) != null)
    {
        System.out.println(s);
        //your business logic here
    }*/
  /*  @Value("${amazon.aws.region}")
    private String amazonAWSRegion;

    @Bean(name = "client")
    public AmazonDynamoDB client() {
        ClientConfiguration clientConfiguration = new ClientConfiguration()
                .withMaxErrorRetry(3)
                .withConnectionTimeout(3000)
                .withSocketTimeout(5000);

        AWSCredentialsProvider awsCredentialsProvider = new DefaultAWSCredentialsProviderChain();

        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(amazonAWSRegion)
                .withClientConfiguration(clientConfiguration)
                .build();
    }*/
}
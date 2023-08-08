package com.nykaa.wishlist.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.nykaa.wishlist.model.Product;
import com.nykaa.wishlist.model.TestProduct;
import com.nykaa.wishlist.repository.ProductRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
/*public interface ProductRepository extends CrudRepository<Product,String> {
}*/

@EnableScan



public class ProductRepository {


    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Product save(Product product) {
        dynamoDBMapper.save(product);
        return product;
    }

    public Product findById(String id) {
        return dynamoDBMapper.load(Product.class, id);
    }
    public TestProduct findAll() {return null;
//    return dynamoDBMapper.scan(Product.class, new DynamoDBScanExpression());
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






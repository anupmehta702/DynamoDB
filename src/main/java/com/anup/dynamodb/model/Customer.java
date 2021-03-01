package com.anup.dynamodb.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Getter(onMethod_ = @DynamoDbPartitionKey)
    private String id;

    @Getter(onMethod_ = @DynamoDbSortKey)
    private String name;

    private String email;

}

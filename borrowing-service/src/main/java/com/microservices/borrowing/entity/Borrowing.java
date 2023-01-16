package com.microservices.borrowing.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Date;

@Document("borrow")
@Data
public class Borrowing {

    @Id
    private String borrowingId;
    private Long bookId;
    private Long customerId;

    private String borrowDate= new Date(System.currentTimeMillis()).toString();
    private Boolean returned=false;

}

package com.microservices.borrowing.repository;

import com.microservices.borrowing.entity.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends MongoRepository<Borrowing, String> {
}

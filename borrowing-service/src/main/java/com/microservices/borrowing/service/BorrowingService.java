package com.microservices.borrowing.service;

import com.microservices.borrowing.entity.Borrowing;
import com.microservices.borrowing.repository.BorrowingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    public Borrowing saveBorrowing(Borrowing borrowing) {
        log.info("Inside saveBorrowing of BorrowingService");
        return borrowingRepository.save(borrowing);
    }

    public Optional<Borrowing> findBorrowingById(Long customerId) {
        log.info("Inside findBorrowingById of BorrowingService");
        return borrowingRepository.findById(customerId);
    }

    public List<Borrowing> findAllBorrowing() {
        log.info("Inside findAllBorrowing of BorrowingService");
        return borrowingRepository.findAll();
    }

    public void deleteBorrowingById(Long borrowingId){
        log.info("Inside deleteBorrowingById of BorrowingService");
        borrowingRepository.deleteById(borrowingId);
    }


}

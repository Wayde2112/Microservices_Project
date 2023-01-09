package com.microservices.borrowing.service;

import com.microservices.borrowing.entity.Borrowing;
import com.microservices.borrowing.exceptions.BorrowingNotFoundException;
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

    public Borrowing findBorrowingById(Long customerId) {
        try{
            log.info("Inside findBorrowingById of BorrowingService");
            Optional <Borrowing> BorrowingOpt = borrowingRepository.findById(customerId);
            if(BorrowingOpt.isPresent()){
                return BorrowingOpt.get();
            }else {
                BorrowingNotFoundException exception = new BorrowingNotFoundException();
                log.info("Exception: "+exception.getMessage());
                throw exception;
            }
        }catch (Exception e){
            BorrowingNotFoundException exception = new BorrowingNotFoundException();
            log.info("Exception: "+exception.getMessage());
            throw exception;
        }
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

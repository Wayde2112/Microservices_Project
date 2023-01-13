package com.microservices.borrowing.service;

import com.microservices.borrowing.entity.Borrowing;
import com.microservices.borrowing.exceptions.BorrowingNotFoundException;
import com.microservices.borrowing.exceptions.BorrowingServerErrorException;
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
    private Long borrowingId;

    public Borrowing saveBorrowing(Borrowing borrowing) {
        try{
            log.info("Inside saveBorrowing of BorrowingService");
            return borrowingRepository.save(borrowing);
        }catch (Exception e){
            BorrowingServerErrorException exception = new BorrowingServerErrorException();
            log.error("Exception: "+exception.getMessage());
            throw exception;
        }
    }

    public Borrowing findBorrowingById(String customerId) {
        try{
            log.info("Inside findBorrowingById of BorrowingService");
            Optional <Borrowing> BorrowingOpt = borrowingRepository.findById(customerId);
            if(BorrowingOpt.isPresent()){
                return BorrowingOpt.get();
            }else {
                BorrowingNotFoundException exception = new BorrowingNotFoundException();
                log.error("Exception: "+exception.getMessage());
                throw exception;
            }
        }catch (Exception e){
            BorrowingServerErrorException exception = new BorrowingServerErrorException();
            log.error("Exception: "+exception.getMessage());
            throw exception;
        }
    }

    public List<Borrowing> findAllBorrowing() {
        try {
            log.info("Inside findAllBorrowing of BorrowingService");
            return borrowingRepository.findAll();
        }catch (Exception e){
            BorrowingServerErrorException exception = new BorrowingServerErrorException();
            log.error("Exception: "+exception.getMessage());
            throw exception;
        }
    }

    public void deleteBorrowingById(String borrowingId){
        try{
            log.info("Inside deleteBorrowingById of BorrowingService");
            borrowingRepository.deleteById(borrowingId);
        }catch (Exception e){
            BorrowingServerErrorException exception = new BorrowingServerErrorException();
            log.error("Exception: "+exception.getMessage());
            throw exception;
        }
    }


}

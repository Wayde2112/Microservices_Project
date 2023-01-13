package com.microservices.borrowing.controller;

import com.microservices.borrowing.entity.Borrowing;
import com.microservices.borrowing.service.BorrowingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@Slf4j
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    // CREATE
    @PostMapping("borrowing")
    public Borrowing saveBorrowing(@RequestBody Borrowing borrowing) {
        log.info("create a new customer");
        System.out.println(borrowing);
        return borrowingService.saveBorrowing(borrowing);
    }

    // READ ALL
    @GetMapping("borrowing")
    public List<Borrowing> getAllBorrowing(){
        log.info("get all borrowings");
        return borrowingService.findAllBorrowing();
    }

    // READ ONE
    @GetMapping("borrowing/{id}")
    public Optional<Borrowing> findBorrowingById (@PathVariable("id") String borrowingId) {
        log.info("get borrowing by id");
        return Optional.ofNullable(borrowingService.findBorrowingById(borrowingId));
    }

    // UPDATE
    @PutMapping("borrowing/{id}")
    public Borrowing updateBorrowing (@RequestBody Borrowing borrowing, @PathVariable("id") String borrowingId){
        log.info("borrowing updated");
        return borrowingService.saveBorrowing(borrowing);
    }

    // DELETE
    @DeleteMapping("borrowing/{id}")
    public void deleteBorrowingById (@PathVariable("id") String borrowingId) {
        log.info("borrowing deleted");
        borrowingService.deleteBorrowingById(borrowingId);
    }
}

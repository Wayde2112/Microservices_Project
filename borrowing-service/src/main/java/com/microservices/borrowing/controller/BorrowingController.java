package com.microservices.borrowing.controller;

import com.microservices.borrowing.entity.Borrowing;
import com.microservices.borrowing.service.BorrowingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/borrowing")
@Slf4j
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    // CREATE
    @PostMapping("/")
    public Borrowing saveBorrowing(@RequestBody Borrowing borrowing) {
        log.info("create a new customer");
        return borrowingService.saveBorrowing(borrowing);
    }

    // READ ALL
    @GetMapping("/")
    public List<Borrowing> getAllBorrowing(){
        log.info("get all borrowings");
        return borrowingService.findAllBorrowing();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<Borrowing> findBorrowingById (@PathVariable("id") Long borrowingId) {
        log.info("get borrowing by id");
        return borrowingService.findBorrowingById(borrowingId);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Borrowing updateBorrowing (@RequestBody Borrowing borrowing, @RequestBody Long borrowingId){
        log.info("borrowing updated");
        return borrowingService.saveBorrowing(borrowing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBorrowingById (@PathVariable("id") Long borrowingId) {
        log.info("borrowing deleted");
        borrowingService.deleteBorrowingById(borrowingId);
    }
}

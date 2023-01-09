package com.microservices.borrowing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.GONE, reason = "Book not available")
public class BorrowingNotAvailableException extends RuntimeException {
}

package com.microservices.borrowing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server error")
public class BorrowingServerErrorException extends RuntimeException {
}


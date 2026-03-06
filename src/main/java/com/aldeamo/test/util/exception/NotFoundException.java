package com.aldeamo.test.util.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String noDataForThisDate) {
        super("Not Found data: " + noDataForThisDate);
    }
}

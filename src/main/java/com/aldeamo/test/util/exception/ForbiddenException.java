package com.aldeamo.test.util.exception;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException() {
        super("Forbidden request");
    }
}

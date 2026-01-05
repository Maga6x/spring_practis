package org.example.spring_practis.exception;

public class UniqueException extends RuntimeException {

    public UniqueException() {
        super();
    }

    public UniqueException(String message) {
        super(message);
    }
}

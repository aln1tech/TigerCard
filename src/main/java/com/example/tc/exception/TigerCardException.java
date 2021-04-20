package com.example.tc.exception;

public class TigerCardException extends RuntimeException {
    public TigerCardException(final String message) {
        super(message);
    }

    public TigerCardException(final RuntimeException exception) {
        super(exception);
    }
}

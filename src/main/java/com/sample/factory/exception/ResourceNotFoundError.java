package com.sample.factory.exception;

public class ResourceNotFoundError extends Exception {

    public ResourceNotFoundError(String message) {
        super(message);
    }
}

package com.example.lilylane.couriers.exceptions;

/**
 * used for the type Not found exception.
 */
public class NotFoundException extends RuntimeException {
    /**
     * used for instantiates a new Not found exception.
     */
    public NotFoundException() {
        super();
    }

    /**
     * used for instantiates a new Not found exception.
     *
     * @param message the message
     */
    public NotFoundException(String message) {
        super(message);
    }
}

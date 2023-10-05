package com.example.lilylane.couriers.exceptions;

/**
 * used for the type Unprocessable entity exception.
 */
public class UnprocessableEntityException extends RuntimeException {
    /**
     * used for instantiates a new Unprocessable entity exception.
     */
    public UnprocessableEntityException() {
        super();
    }

    /**
     * used for instantiates a new Unprocessable entity exception.
     *
     * @param message the message
     */
    public UnprocessableEntityException(String message) {
        super(message);
    }
}

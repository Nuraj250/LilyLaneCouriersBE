package com.example.lilylane.couriers.exceptions;

/**
 * used for the type expectation failed exception.
 */
public class ExpectationFailedException extends RuntimeException {
    /**
     * used for instantiates a new Expectation failed exception.
     */
    public ExpectationFailedException() {
        super();
    }

    /**
     * used for instantiates a new Expectation failed exception.
     *
     * @param message the message
     */
    public ExpectationFailedException(String message) {
        super(message);
    }
}

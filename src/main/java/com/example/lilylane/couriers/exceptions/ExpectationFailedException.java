package com.example.lilylane.couriers.exceptions;

/**
 * The type expectation failed exception.
 *
 */
public class ExpectationFailedException extends RuntimeException {
    /**
     * Instantiates a new Expectation failed exception.
     */
    public ExpectationFailedException() {
        super();
    }

    /**
     * Instantiates a new Expectation failed exception.
     *
     * @param message the message
     */
    public ExpectationFailedException(String message) {
        super(message);
    }
}

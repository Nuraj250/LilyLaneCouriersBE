package com.example.lilylane.couriers.exceptions;

/**
 * The type invalid argument exception.
 *
 */
public class InvalidArgumentException extends RuntimeException {
    /**
     * Instantiates a new Invalid argument exception.
     */
    public InvalidArgumentException() {
        super();
    }

    /**
     * Instantiates a new Invalid argument exception.
     *
     * @param msg the msg
     */
    public InvalidArgumentException(String msg) {
        super(msg);
    }
}

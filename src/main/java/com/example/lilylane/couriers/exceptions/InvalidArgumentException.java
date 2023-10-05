package com.example.lilylane.couriers.exceptions;

/**
 * used for the type invalid argument exception.
 */
public class InvalidArgumentException extends RuntimeException {
    /**
     * used for instantiates a new Invalid argument exception.
     */
    public InvalidArgumentException() {
        super();
    }

    /**
     * used for instantiates a new Invalid argument exception.
     *
     * @param msg the msg
     */
    public InvalidArgumentException(String msg) {
        super(msg);
    }
}

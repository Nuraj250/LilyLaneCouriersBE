package com.example.lilylane.couriers.exceptions;

/**
 * used for the type Un authorized exception.
 */
public class UnAuthorizedException extends RuntimeException {

    /**
     * used for instantiates a new Un authorized exception.
     */
    public UnAuthorizedException() {
        super();
    }

    /**
     * used for instantiates a new Un authorized exception.
     *
     * @param msg the msg
     */
    public UnAuthorizedException(String msg) {
        super(msg);
    }
}

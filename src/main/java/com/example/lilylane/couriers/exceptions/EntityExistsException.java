package com.example.lilylane.couriers.exceptions;

/**
 * used for the type Entity not exists exception.
 */
public class EntityExistsException extends RuntimeException {
    /**
     * used for instantiates a new Entity not exists exception.
     *
     * @param id the id
     */
    public EntityExistsException(Long id) {
        super("Existing entity found for id - " + id);
    }

    /**
     * used for instantiates a new Entity not exists exception.
     *
     * @param property
     * @param value
     */
    public EntityExistsException(String property, String value) {
        super("Existing entity found for " + property + " - " + value);
    }

}

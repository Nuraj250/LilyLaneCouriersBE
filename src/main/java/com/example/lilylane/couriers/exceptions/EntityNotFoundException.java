package com.example.lilylane.couriers.exceptions;

/**
 * used for the type Entity not found exception.
 */
public class EntityNotFoundException extends RuntimeException {
    /**
     * used for instantiates a new Entity not found exception.
     *
     * @param id the id
     */
    public EntityNotFoundException(Long id) {
        super("Could not find entity for id - " + id);
    }

    /**
     * used for instantiates a new Entity not found exception.
     *
     * @param name
     */
    public EntityNotFoundException(String name) {
        super("Could not find entity for name - " + name);
    }
}

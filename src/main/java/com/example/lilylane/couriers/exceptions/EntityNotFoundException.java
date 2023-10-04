package com.example.lilylane.couriers.exceptions;

/**
 * The type Entity not found exception.
 */
public class EntityNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Entity not found exception.
     *
     * @param id the id
     */
    public EntityNotFoundException(Long id) {
        super("Could not find entity for id - " + id);
    }

    public EntityNotFoundException(String name) {
        super("Could not find entity for name - " + name);
    }
}

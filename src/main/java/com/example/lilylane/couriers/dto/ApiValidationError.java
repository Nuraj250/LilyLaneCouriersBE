package com.example.lilylane.couriers.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * used to represent validation errors in an API response
 */
@Getter
@Setter
public class ApiValidationError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1781211130961571205L;
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    /**
     * used to instantiate a new Api Validation error.
     * @param object
     * @param message
     */
    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    /**
     * used to instantiate a new Api Validation error.
     * @param object
     * @param field
     * @param rejectedValue
     * @param message
     */
    public ApiValidationError(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }

    /**
     * used to override the method to provide custom one based on the object, field, rejectedValue, and message fields.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiValidationError that = (ApiValidationError) o;
        return object.equals(that.object) && field.equals(that.field) && rejectedValue.equals(that.rejectedValue) && message.equals(that.message);
    }

    /**
     * used to overrides the hashCode method to provide a custom one based on the object, field, rejectedValue, and message fields
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(object, field, rejectedValue, message);
    }
}

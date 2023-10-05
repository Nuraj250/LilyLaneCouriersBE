package com.example.lilylane.couriers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * used for representing error responses in a web application
 */
@Data
@AllArgsConstructor
public class ApiError implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private List<ApiValidationError> validationErrors;

    /**
     * used to Instantiate a new Api error.
     */
    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    /**
     * used to instantiate a new Api error.
     *
     * @param status the status
     */
    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    /**
     * used to instantiate a new Api error.
     *
     * @param status  the status
     * @param message the message
     */
    public ApiError(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    /**
     * used to add a single ApiValidationError object to the list
     *
     * @param subError
     */
    private void addValidationErrors(ApiValidationError subError) {
        if (validationErrors == null) {
            validationErrors = new ArrayList<>();
        }
        validationErrors.add(subError);
    }

    /**
     * used to add a validation error with details about the object, field, rejected value, and a message
     *
     * @param object
     * @param field
     * @param rejectedValue
     * @param message
     */
    private void addValidationError(String object, String field, Object rejectedValue, String message) {
        addValidationErrors(new ApiValidationError(object, field, rejectedValue, message));
    }

    /**
     * used to add a validation error with details about the object and a message
     *
     * @param object
     * @param message
     */
    private void addValidationError(String object, String message) {
        addValidationErrors(new ApiValidationError(object, message));
    }

    /**
     * used to add a validation error based on a FieldError object.
     *
     * @param fieldError
     */
    private void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    /**
     * used to add a list of field-level validation errors.
     *
     * @param fieldErrors
     */
    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    /**
     * used to add a validation error based on an ObjectError object.
     *
     * @param objectError
     */
    private void addValidationError(ObjectError objectError) {
        this.addValidationError(
                objectError.getObjectName(),
                objectError.getDefaultMessage());
    }

    /**
     * used to add a list of global validation errors.
     *
     * @param globalErrors
     */
    public void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }

}

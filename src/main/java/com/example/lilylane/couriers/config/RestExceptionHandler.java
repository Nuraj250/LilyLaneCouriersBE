package com.example.lilylane.couriers.config;

import com.example.lilylane.couriers.dto.ApiError;
import com.example.lilylane.couriers.exceptions.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles UnAuthorizedException. Thrown when not authorized.
     *
     * @param ex the UnAuthorizedException
     * @return a {@code ResponseEntity} instance
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<Object> handleUnAuthorized(UnAuthorizedException ex) {
        return buildResponseEntity(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    /**
     * Unprocessable entity handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ExceptionHandler({UnprocessableEntityException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> unprocessableEntityHandler(UnprocessableEntityException ex) {
        return buildResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
    }

    /**
     * Parent not found handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ExceptionHandler({EntityNotFoundException.class, NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> notFoundHandler(RuntimeException ex) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /**
     * Entity exists exception
     *
     * @param ex the exception
     * @return the API error instance as the response
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> conflictHandler(EntityExistsException ex) {
        return buildResponseEntity(HttpStatus.CONFLICT, ex.getMessage());
    }

    /**
     * Invalid argument handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> invalidArgumentHandler(InvalidArgumentException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * Expectation failed handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ExceptionHandler(ExpectationFailedException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Object> expectationFailedHandler(ExpectationFailedException ex) {
        return buildResponseEntity(HttpStatus.EXPECTATION_FAILED, ex.getMessage());
    }

    /**
     * common method to build the final response entity
     *
     * @param apiError api error object
     * @return a {@code ResponseEntity} instance
     */
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    /**
     * common method to build the final response entity
     *
     * @param status  the selected response status
     * @param message the selected response message
     * @return a {@code ResponseEntity} instance
     */
    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message) {
        ApiError apiError = new ApiError(status);
        apiError.setMessage(message);
        return buildResponseEntity(apiError);
    }


    /**
     * Handle Exception, handle generic Exception.class
     *
     * @param ex the Exception
     * @return a {@code ResponseEntity} instance
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
        return buildResponseEntity(apiError);
    }

    /**
     * Handle user disabled response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({DisabledException.class})
    @ResponseStatus(HttpStatus.LOCKED)
    public ResponseEntity<Object> handleUserDisabled(RuntimeException ex) {
        return buildResponseEntity(HttpStatus.LOCKED, ex.getMessage());
    }
}


package com.example.lilylane.couriers.security;

import com.example.lilylane.couriers.dto.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

/**
 * used to  for handling authentication errors in a Spring Security configuration
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Serial
    private static final long serialVersionUID = -7858869558953243875L;

    private final ObjectMapper objectMapper;

    public JwtAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * used when an unauthenticated user attempts to access a secured resource.
     * It handles the authentication failure and sends an error response
     *
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        final ApiError apiError = new ApiError();
        apiError.setMessage("Invalid token");
        apiError.setStatus(HttpStatus.UNAUTHORIZED);

        final ServletOutputStream writer = response.getOutputStream();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        writer.write(objectMapper.writeValueAsBytes(apiError));
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        writer.flush();
    }
}

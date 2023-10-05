package com.example.lilylane.couriers.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * This class is used to represent an authentication request object in an application
 */
@Data
public class AuthRequest implements Serializable {

    private String username;
    private String password;
}

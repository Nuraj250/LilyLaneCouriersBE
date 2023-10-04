package com.example.lilylane.couriers.dto.response;

import com.example.lilylane.couriers.model.Users;
import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {

    private final Long id;
    private final String name;
    private final String email;
    private final String username;

    public JwtResponse(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}

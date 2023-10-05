package com.example.lilylane.couriers.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * This class  represent user-related data
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
}

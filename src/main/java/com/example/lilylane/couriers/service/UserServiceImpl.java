package com.example.lilylane.couriers.service;

import com.example.lilylane.couriers.dto.request.AuthRequest;
import com.example.lilylane.couriers.dto.request.UserDTO;
import com.example.lilylane.couriers.model.Users;
import com.example.lilylane.couriers.util.ResponseMessage;


/**
 * used to define a set of user-related operations in application.
 */
public interface UserServiceImpl {
    Users findUserByUsername(String username);

    Users authenticate(AuthRequest authRequest);

    ResponseMessage register(UserDTO userRequest);

}

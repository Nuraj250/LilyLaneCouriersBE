package com.example.lilylane.couriers.service;

import com.example.lilylane.couriers.dto.request.AuthRequest;
import com.example.lilylane.couriers.dto.request.UserDTO;
import com.example.lilylane.couriers.exceptions.EntityExistsException;
import com.example.lilylane.couriers.exceptions.EntityNotFoundException;
import com.example.lilylane.couriers.exceptions.UnAuthorizedException;
import com.example.lilylane.couriers.model.Users;
import com.example.lilylane.couriers.repository.UserRepository;
import com.example.lilylane.couriers.util.Alerts;
import com.example.lilylane.couriers.util.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService implements UserServiceImpl{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public Users findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);    }

    @Override
    public Users authenticate(AuthRequest authRequest) {
        Users existUser = this.userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(()-> new EntityNotFoundException(authRequest.getUsername()));
        if (passwordEncoder.matches(authRequest.getPassword(), existUser.getPassword())){
            return existUser;
        }else {
            throw new UnAuthorizedException("Password doesn't match for user");
        }

    }

    @Override
    public ResponseMessage register(UserDTO userRequest) {
        Optional<Users> existingUser = userRepository.findByUsername(userRequest.getUsername());
        if (existingUser.isPresent())
            throw new EntityExistsException("username", userRequest.getUsername());
        Users user = new Users();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));


        Users users= userRepository.save(user);
        return new ResponseMessage(200, Alerts.saveSuccess, users);
    }
}

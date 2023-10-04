package com.example.lilylane.couriers.controller;

import com.example.lilylane.couriers.dto.request.AuthRequest;
import com.example.lilylane.couriers.dto.request.UserDTO;
import com.example.lilylane.couriers.dto.response.JwtResponse;
import com.example.lilylane.couriers.model.Users;
import com.example.lilylane.couriers.security.JwtTokenUtil;
import com.example.lilylane.couriers.security.JwtUserDetailsService;
import com.example.lilylane.couriers.service.UserServiceImpl;
import com.example.lilylane.couriers.util.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@RequestMapping("/auth")
public class UserAuthController {
    private final UserServiceImpl userService;
    private final JwtUserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthRequest authRequest) {
        Users existingUser = userService.authenticate(authRequest);
        final UserDetails userDetails = userDetailsService.loadUserByUsername( existingUser.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(existingUser));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody @Validated UserDTO userRequest) {
        ResponseMessage existingUser = userService.register(userRequest);
        return ResponseEntity.ok(existingUser);
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(Principal principal){
        String name = principal.getName();
        log.info("Authenticate User : "+ name);
        return ResponseEntity.ok().build();
    }
}

package com.example.lilylane.couriers.repository;

import com.example.lilylane.couriers.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * used as a repository for database operations related to the Users entity.
 */
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

}

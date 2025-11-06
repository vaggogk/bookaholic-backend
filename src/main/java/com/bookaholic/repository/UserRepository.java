package com.bookaholic.repository;

import com.bookaholic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //  Check if username exists
    Optional<User> findByUsername(String username);

      // Check if email exists
    Optional<User> findByEmail(String email);

      // find username by username
    boolean existsByUsername(String username);

    // find email  by email
    boolean existsByEmail(String email);
}
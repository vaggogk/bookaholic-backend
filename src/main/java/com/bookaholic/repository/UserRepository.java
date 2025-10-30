package com.bookaholic.repository;

import com.bookaholic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 🔍 Βρες user από username
    Optional<User> findByUsername(String username);

    // 📧 Βρες user από email
    Optional<User> findByEmail(String email);

    // ✅ Έλεγχος αν υπάρχει username
    boolean existsByUsername(String username);

    // ✅ Έλεγχος αν υπάρχει email
    boolean existsByEmail(String email);
}
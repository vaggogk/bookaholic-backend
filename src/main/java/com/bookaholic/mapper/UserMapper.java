package com.bookaholic.mapper;

import com.bookaholic.DTO.RegisterDTO;
import com.bookaholic.DTO.UserReadOnlyDTO;
import com.bookaholic.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public User mapToUserEntity(RegisterDTO dto) {
        return new User(null,
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword(),
                LocalDateTime.now(),
                null);
    }

    public UserReadOnlyDTO mapToUserReadOnlyDTO(User user) {
        return  new UserReadOnlyDTO(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt());
    }
}

package com.bookaholic.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDTO {
    @NotNull(message = "Name cannot be null.")
    @Size(min = 3, max = 20,
          message = "Name must be at least 3 characters long")
       private String username;

    @NotNull(message = "The email cannot be null.")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotNull(message = "The password cant be null.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])^.{12,}$",
             message = "Password must contain at least 1 lowercase, 1 uppercase, 1 number and 1 special character with no space.")
        private String password;

    @NotNull(message = "Confirm password cannot be null.")
    private String confirmPassword;

    }


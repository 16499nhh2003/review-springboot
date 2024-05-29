package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class CurrentUserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer currSessionId;

    @NotNull(message = "Email is require")
    @Email
    private String email;

    @NotNull(message = "Date time is require")
    private LocalDateTime loginDateTime;

    @NotNull(message = "Role is require")
    private String role;

    private String privateKey;

}

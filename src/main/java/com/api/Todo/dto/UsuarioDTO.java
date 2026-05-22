package com.api.Todo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record UsuarioDTO(
       @NotNull
       @NotBlank
        String nome,

        @NotNull
        @NotBlank
        @Email
        String email,

        @NotNull
        @NotBlank
        String senha
) {}

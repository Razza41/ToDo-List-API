package com.api.Todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Entity
@Data
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @Email
    @NotNull
    private String email;

   @NotNull
    private String senha;
}

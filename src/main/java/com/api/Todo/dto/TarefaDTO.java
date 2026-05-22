package com.api.Todo.dto;

import com.api.Todo.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TarefaDTO(
        @NotNull
        @NotBlank
        String titulo,

        @NotNull
        String descricao,

        @NotNull
        StatusEnum status,

        @JsonFormat(pattern = "dd/MM/yyyy")
        Date prazo
){}

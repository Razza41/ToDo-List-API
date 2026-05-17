package com.api.Todo.entity;

import com.api.Todo.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "tarefa")
public class TarefaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    private StatusEnum status;

    @NotNull
    @JsonFormat(pattern = "dd/mm/yyyy") //pega o formato dado no JSON e passa pra variavel
    private Date prazo;


}

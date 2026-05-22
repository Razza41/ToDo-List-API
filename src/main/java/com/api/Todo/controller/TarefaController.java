package com.api.Todo.controller;

import com.api.Todo.dto.TarefaDTO;
import com.api.Todo.entity.TarefaEntity;
import com.api.Todo.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaEntity> postTarefa(@Valid @RequestBody TarefaDTO tarefaDTO){
        TarefaEntity tarefa = tarefaService.criarTarefa(tarefaDTO); //Converto o DTO para Entity
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa); //retorno o status http de criado
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<TarefaEntity> getTarefa(@PathVariable ("id")Long id){
        return ResponseEntity.ok(tarefaService.buscarPorID(id));

    }
}

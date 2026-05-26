package com.api.Todo.controller;

import com.api.Todo.dto.TarefaDTO;
import com.api.Todo.entity.TarefaEntity;
import com.api.Todo.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaEntity> postTarefa(@Valid @RequestBody TarefaDTO tarefaDTO) {
        TarefaEntity tarefa = tarefaService.criarTarefa(tarefaDTO); //Converto o DTO para Entity
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa); //retorno o status http de criado
    }

    @GetMapping(value = "/{id}") //necessario para definir na URL
    public ResponseEntity<TarefaEntity> getTarefa(@PathVariable("id") Long id) { //PathVariable para "ligar" uma variavel no valor passado na URL
        return ResponseEntity.ok(tarefaService.buscarPorID(id));
    }

    @GetMapping
   public ResponseEntity<List<TarefaEntity>> listarTarefas(){
        List <TarefaEntity> tarefas = tarefaService.listarTarefa(); //Pega as informacoes e coloca em uma lista
        return ResponseEntity.ok(tarefas); //retorna OK no PostMan
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable ("id") Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build(); //build constroi a resposta no meu body
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<TarefaEntity> atualizarTarefa( @PathVariable ("id")
                                                            Long id, @Valid @RequestBody TarefaDTO novaTarefa){
        TarefaEntity tarefa = tarefaService.atualizarTarefa(id,novaTarefa);
        return ResponseEntity.ok(tarefa);
    }
}

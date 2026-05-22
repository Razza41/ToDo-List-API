package com.api.Todo.service;

import com.api.Todo.dto.TarefaDTO;
import com.api.Todo.entity.TarefaEntity;
import com.api.Todo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaEntity criarTarefa(TarefaDTO tarefaDTO){

        TarefaEntity tarefa = TarefaEntity.builder()
                .titulo(tarefaDTO.titulo())
                .descricao(tarefaDTO.descricao())
                .status(tarefaDTO.status())
                .prazo(tarefaDTO.prazo())
                .build();

        return tarefaRepository.save(tarefa);
    }

    public TarefaEntity buscarPorID(Long id){
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }


}

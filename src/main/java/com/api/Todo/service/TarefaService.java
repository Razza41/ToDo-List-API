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

    //criacao de tarefa usando o DTO
    public TarefaEntity criarTarefa(TarefaDTO tarefaDTO){

        TarefaEntity tarefa = TarefaEntity.builder()
                .titulo(tarefaDTO.titulo())
                .descricao(tarefaDTO.descricao())
                .status(tarefaDTO.status())
                .prazo(tarefaDTO.prazo())
                .build();

        return tarefaRepository.save(tarefa);
    }

    //busca tarefa pelo ID
    public TarefaEntity buscarPorID(Long id){
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }


    //deleta tarefa pelo id
    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    public TarefaEntity atualizarTarefa(Long id, TarefaDTO novaTarefa){
        System.out.println(">>> DTO: " + novaTarefa); // <-- adiciona aqui

        TarefaEntity tarefa = tarefaRepository.findById(id) //cria uma entity para pesquisar a tarefa pelo ID e retorna o sout caso ela nao exista
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        tarefa.setTitulo(novaTarefa.titulo());
        tarefa.setDescricao(novaTarefa.descricao());
        tarefa.setStatus(novaTarefa.status());
        tarefa.setPrazo(novaTarefa.prazo());

        return tarefaRepository.save(tarefa); //salva no banco de dados
    }

}

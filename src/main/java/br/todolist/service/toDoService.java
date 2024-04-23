package br.todolist.service;

import br.todolist.repository.toDoRepository;
import br.todolist.entity.toDoEt;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class toDoService {
    private toDoEt toDoEt;

    private final br.todolist.repository.toDoRepository toDoRepository;

    public toDoService(toDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public toDoEt create(toDoEt todo){
          return  toDoRepository.save(todo);
    }

    public List<toDoEt> list(){
        Sort sort = Sort.by("Prioridade").descending().and(Sort.by("nome").ascending());
        return toDoRepository.findAll(sort);
    }

    public List<toDoEt> update(toDoEt todo){
        toDoRepository.save(todo);
        return list();
    }

    public List<toDoEt> delete(Long id){
        toDoRepository.deleteById(id);
        return list();
    }
}

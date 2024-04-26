package br.todolist.service;

import br.todolist.repository.ToDoRepository;
import br.todolist.entity.ToDoEt;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private ToDoEt toDoEt;

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDoEt create(ToDoEt todo){
          return  toDoRepository.save(todo);
    }

    public List<ToDoEt> list(){
        Sort sort = Sort.by("Prioridade").descending().and(Sort.by("nome").ascending());
        return toDoRepository.findAll(sort);
    }

    public List<ToDoEt> update(ToDoEt todo){
        toDoRepository.save(todo);
        return list();
    }

    public List<ToDoEt> delete(Long id){
        toDoRepository.deleteById(id);
        return list();
    }
}

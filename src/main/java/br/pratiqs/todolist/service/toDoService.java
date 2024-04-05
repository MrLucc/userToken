package br.pratiqs.todolist.service;

import br.pratiqs.todolist.entity.toDoEt;
import br.pratiqs.todolist.repository.toDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class toDoService {

    private final toDoRepository toDoRepository;

    public toDoService(toDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<toDoEt> create(toDoEt todo){
        toDoRepository.save(todo);

        return list();
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

package br.todolist.repository;

import br.todolist.entity.ToDoEt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEt, Long> {

}

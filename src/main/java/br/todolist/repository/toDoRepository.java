package br.todolist.repository;

import br.todolist.entity.toDoEt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface toDoRepository extends JpaRepository<toDoEt, Long> {

}

package br.pratiqs.todolist.repository;

import br.pratiqs.todolist.entity.toDoEt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface toDoRepository extends JpaRepository<toDoEt, Long> {

}

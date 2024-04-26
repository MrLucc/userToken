package br.todolist.controller;

import br.todolist.service.ToDoService;
import br.todolist.entity.ToDoEt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private ToDoService toDoService;

   public ToDoController(ToDoService toDoService){
       this.toDoService = toDoService;
   }

   @PostMapping
   ToDoEt create(@RequestBody ToDoEt todo){
       return toDoService.create(todo);
   }

   @GetMapping
    List<ToDoEt> list(){
       return toDoService.list();
   }

   @PutMapping()
    List<ToDoEt> update(@RequestBody ToDoEt todo){
       return toDoService.update(todo);
   }

   @DeleteMapping("{id}")
    List<ToDoEt> delete(@PathVariable("id")Long id){
       return toDoService.delete(id);
   }
}

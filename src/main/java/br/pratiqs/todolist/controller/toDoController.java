package br.pratiqs.todolist.controller;

import br.pratiqs.todolist.entity.toDoEt;
import br.pratiqs.todolist.service.toDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class toDoController {
    private toDoService toDoService;

   public toDoController(toDoService toDoService){
       this.toDoService = toDoService;
   }

   @PostMapping
   List<toDoEt> create(@RequestBody toDoEt todo){
       return toDoService.create(todo);
   }

   @GetMapping
    List<toDoEt> list(){
       return toDoService.list();
   }

   @PutMapping
    List<toDoEt> update(@RequestBody toDoEt todo){
       return toDoService.update(todo);
   }

   @DeleteMapping("{id}")
    List<toDoEt> delete(@PathVariable("id")Long id){
       return toDoService.delete(id);
   }
}

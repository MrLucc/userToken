package br.todolist.controller;

import br.todolist.service.toDoService;
import br.todolist.entity.toDoEt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class toDoController {
    private br.todolist.service.toDoService toDoService;

   public toDoController(toDoService toDoService){
       this.toDoService = toDoService;
   }

   @PostMapping
   toDoEt create(@RequestBody toDoEt todo){
       return toDoService.create(todo);
   }

   @GetMapping
    List<toDoEt> list(){
       return toDoService.list();
   }

   @PutMapping()
    List<toDoEt> update(@RequestBody toDoEt todo){
       return toDoService.update(todo);
   }

   @DeleteMapping("{id}")
    List<toDoEt> delete(@PathVariable("id")Long id){
       return toDoService.delete(id);
   }
}

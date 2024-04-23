package br.user.controller;

import br.user.service.userService;
import br.user.entity.userEt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    private final userService pUserService;

    public userController(userService pUserService){
        this.pUserService = pUserService;
    }

    @PostMapping
    userEt create(@RequestBody userEt user){

        return pUserService.create(user);
    }

   @GetMapping
   List<userEt> list(){
        return pUserService.list();
   }
}

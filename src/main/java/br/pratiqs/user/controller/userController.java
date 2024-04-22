package br.pratiqs.user.controller;

import br.pratiqs.user.entity.userEt;
import br.pratiqs.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
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

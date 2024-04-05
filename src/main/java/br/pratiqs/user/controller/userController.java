package br.pratiqs.user.controller;

import br.pratiqs.user.entity.userEt;
import br.pratiqs.user.service.userService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

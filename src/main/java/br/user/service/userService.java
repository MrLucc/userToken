package br.user.service;

import br.core.adapter.driven.userRepository;
import br.core.domain.UserEt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private final br.core.adapter.driven.userRepository userRepository;

    public userService(userRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEt create(UserEt user){
        return userRepository.save(user);
    }

    public List<UserEt> list(){
        return userRepository.findAll();
    }

//    public ResponseEntity<UserEt> update(UserEt user){
//
//    }

}

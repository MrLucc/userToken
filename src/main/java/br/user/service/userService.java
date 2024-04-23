package br.user.service;

import br.user.repository.userRepository;
import br.user.entity.userEt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private final br.user.repository.userRepository userRepository;

    public userService(userRepository userRepository){
        this.userRepository = userRepository;
    }

    public userEt create(userEt user){
        return userRepository.save(user);
    }

    public List<userEt> list(){
        return userRepository.findAll();
    }
}

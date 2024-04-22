package br.pratiqs.user.service;

import br.pratiqs.user.entity.userEt;
import br.pratiqs.user.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private final userRepository userRepository;

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

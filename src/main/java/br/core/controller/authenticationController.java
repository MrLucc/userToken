package br.core.controller;

import br.core.dto.authenticationDTO;
import br.core.dto.registerDTO;
import br.user.entity.userEt;
import br.user.repository.userRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private userRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid authenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid registerDTO data){
        if(this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        userEt newUser = new userEt(data.email(), encryptedPassword, data.Role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();

    }
}

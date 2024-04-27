package br.user.controller;

import br.core.config.security.TokenService;
import br.core.dto.AuthenticationDTO;
import br.core.dto.LoginResponseDTO;
import br.core.dto.RegisterResponseDTO;
import br.user.repository.userRepository;
import br.user.entity.UserEt;
import jakarta.persistence.Converter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    private userRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generationToken((UserEt) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterResponseDTO data) {
        if (this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().body("Email já existente "+ data.email());

        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserEt newUser = new UserEt(data.email(), encryptedPassword, data.roles(), data.nome());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable(value = "id") Long idUser) {
        userRepository.deleteById(idUser);
    }
}

package br.core.adapter.driver;

import br.core.config.security.TokenService;
import br.core.dto.AuthenticationDTO;
import br.core.dto.LoginResponseDTO;
import br.core.dto.RegisterResponseDTO;
import br.core.adapter.driven.userRepository;
import br.core.domain.UserEt;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    private userRepository userRepository;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO user) {
        ResponseStatusException test;
        var userNamePassword = new UsernamePasswordAuthenticationToken(user.email(), user.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generationToken((UserEt) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterResponseDTO user) {
        if (this.userRepository.findByEmail(user.email()) != null) {
            return ResponseEntity.badRequest().body("Email já existente " + user.email());

        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
        UserEt newUser = new UserEt(user.email(), encryptedPassword, user.roles(), user.nome());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity update(@RequestBody @Valid UserDTO user){
//       Optional<UserEt> optionalUserEt = userRepository.findById(user.id());
//       if(optionalUserEt.isPresent()){
//           String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
//           UserEt userUpdate = UserEt(user.email(),encryptedPassword, user.nome());
//       }
//    }


    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable(value = "id") Long idUser) {
        userRepository.deleteById(idUser);
    }
}

package br.user.repository;

import br.user.entity.userEt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepository extends JpaRepository<userEt, Long> {

    UserDetails findByEmail(String email);
}

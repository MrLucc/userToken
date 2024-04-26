package br.user.repository;

import br.user.entity.UserEt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepository extends JpaRepository<UserEt, Long> {

    UserDetails findByEmail(String email);
}

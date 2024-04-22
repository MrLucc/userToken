package br.pratiqs.user.repository;

import br.pratiqs.user.entity.userEt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepository extends JpaRepository<userEt, Long> {

    UserDetails findByLogin(String email);
}

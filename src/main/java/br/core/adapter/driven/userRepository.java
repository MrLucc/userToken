package br.core.adapter.driven;

import br.core.domain.UserEt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepository extends JpaRepository<UserEt, Long> {

    UserDetails findByEmail(String email);

}

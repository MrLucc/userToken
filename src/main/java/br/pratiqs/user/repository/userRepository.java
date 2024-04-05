package br.pratiqs.user.repository;

import br.pratiqs.user.entity.userEt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<userEt, Long> {
}

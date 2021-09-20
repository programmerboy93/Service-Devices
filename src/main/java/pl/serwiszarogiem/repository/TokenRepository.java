package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    Token findByEmail(String email);

    Token findByToken(String token);
}

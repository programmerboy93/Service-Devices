package pl.serwiszarogiem.service.token;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Token;

@Service
public interface TokenService {

    Token findByEmail(String email);
    Token findByToken(String token);
    void save(Token token);
    void save(String email, String tokenValue);
    void delete(String email);
}

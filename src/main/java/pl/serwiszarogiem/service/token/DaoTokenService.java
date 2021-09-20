package pl.serwiszarogiem.service.token;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Token;
import pl.serwiszarogiem.repository.TokenRepository;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.time.LocalDate;


@Log4j2
@Component
@Primary
public class DaoTokenService implements TokenService {


    private final TokenRepository tokenRepository;

    @Autowired
    public DaoTokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token findByEmail(String email) {
        return tokenRepository.findByEmail(email);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void save(Token token) {
        tokenRepository.save(token);
    }

    @Override
    public void save(String email, String tokenValue) {
        Token token = new Token();
        token.setToken(tokenValue);
        token.setEmail(email);
        token.setExpirationDate(LocalDate.now().plusDays(7));
        tokenRepository.save(token);
    }

    @Transactional
    @Override
    public void delete(String email) {
        tokenRepository.delete(tokenRepository.findByEmail(email));
    }
}

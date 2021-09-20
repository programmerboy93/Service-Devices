package pl.serwiszarogiem.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import pl.serwiszarogiem.dto.NewPasswordDto;
import pl.serwiszarogiem.dto.UserDto;
import pl.serwiszarogiem.entity.Role;
import pl.serwiszarogiem.entity.User;
import pl.serwiszarogiem.repository.UserRepository;
import pl.serwiszarogiem.service.token.TokenService;

import java.util.List;

@Component
@Primary
public class DaoUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Autowired
    public DaoUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void createAccount(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEnabled(true);
        user.setRole(new Role(1L, "ROLE_USER"));
        userRepository.save(user);
    }

    @Override
    public User findByEmailIgnoreCase(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public boolean EmailExistsValidator(UserDto validUser, BindingResult result) {
        if (findByEmailIgnoreCase(validUser.getEmail()) != null) {
            result.rejectValue("email", "user.email", "Popraw e-mail");
        }
        return result.hasErrors();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void saveNewPassword(NewPasswordDto newPasswordDto) {
        User user = userRepository.findByEmailIgnoreCase(newPasswordDto.getEmail());
        user.setPassword(passwordEncoder.encode(newPasswordDto.getPassword()));
        tokenService.delete(newPasswordDto.getEmail());
    }

}

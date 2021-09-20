package pl.serwiszarogiem.service.user;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.serwiszarogiem.dto.NewPasswordDto;
import pl.serwiszarogiem.dto.UserDto;
import pl.serwiszarogiem.entity.User;

import java.util.List;

@Service
public interface UserService {
    void saveNewPassword(NewPasswordDto newPasswordDto);
    User findById(Long id);
    boolean EmailExistsValidator(UserDto validUser, BindingResult result);
    User findByEmailIgnoreCase(String email);
    void createAccount(UserDto userDto);
    List<User> findAllUser();
    void save(User user);
}

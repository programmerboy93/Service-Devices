package pl.serwiszarogiem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.serwiszarogiem.entity.User;
import pl.serwiszarogiem.service.user.DaoUserService;

@Component
public class UserConverter implements Converter<String, User> {

    @Autowired
    private DaoUserService userService;

    @Override
    public User convert(String id) {
        return userService.findById(Long.parseLong(id));
    }
}

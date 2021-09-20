package pl.serwiszarogiem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.User;
import pl.serwiszarogiem.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findByEmailIgnoreCase(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }else
        return new CustomUserDetails(user);
    }

    private User findByEmailIgnoreCase(String email){
        return userRepository.findByEmailIgnoreCaseAndEnabledIsTrue(email);
    }
}

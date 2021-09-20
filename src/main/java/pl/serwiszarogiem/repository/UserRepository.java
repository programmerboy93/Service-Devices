package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailIgnoreCaseAndEnabledIsTrue(String email);

    User findByEmailIgnoreCase(String email);
}

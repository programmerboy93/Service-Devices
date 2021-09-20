package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}

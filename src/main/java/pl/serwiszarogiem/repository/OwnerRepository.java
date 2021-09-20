package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {



}

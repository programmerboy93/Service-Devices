package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.TypeDevices;

@Repository
public interface TypeDeviceRepository extends JpaRepository<TypeDevices,Long> {
}

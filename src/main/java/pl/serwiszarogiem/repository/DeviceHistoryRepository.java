package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.DeviceHistoryRepair;

import java.util.List;

@Repository
public interface DeviceHistoryRepository extends JpaRepository <DeviceHistoryRepair,Long> {

    List <DeviceHistoryRepair> findAllByDeviceId(Long id);
}

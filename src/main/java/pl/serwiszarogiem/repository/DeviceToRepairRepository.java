package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.DeviceToRepair;
import pl.serwiszarogiem.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DeviceToRepairRepository extends JpaRepository<DeviceToRepair,Long> {


    @Query("delete from DeviceToRepair d where d.device.id = ?1")
    void deleteAllByDeviceId(Long id);

    @Transactional
    @Modifying
    @Query("update DeviceToRepair d set d.user=?2 where d.id =?1")
    void update(Long id, User user);


    List<DeviceToRepair> findAllByUserEmail(String email);


    @Query("select d from DeviceToReview d where d.device.id = ?1")
    List<DeviceToRepair> findByDeviceId(Long id);
}

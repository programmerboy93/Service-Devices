package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.Device;
import pl.serwiszarogiem.entity.Shop;
import pl.serwiszarogiem.entity.TypeDevices;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {


    List<Device> findAllByTypeDevices(Optional<TypeDevices> byId);

    List<Device> findAllByShop(Optional<Shop> byId);

    @Query(value = "select * from devices d where adddate(d.review_to,-7) < now() order by review_to;",nativeQuery = true)
    List<Device> findAllDeviceToReview7Days();

    @Query(value = "select d.* from device_to_review dw right join devices d on dw.device_id = d.id\n" +
            "where dw.device_id is null and adddate(d.review_to,-7) < now() order by review_to;",nativeQuery = true)
    List<Device> findAllDeviceToReview7DaysWithoutDeviceToReview();


    List<Device> findAllByOrderByReviewToAsc();
}

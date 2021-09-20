package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.DeviceHistoryReview;

import java.util.List;

@Repository
public interface DeviceHistoryReviewRepository extends JpaRepository<DeviceHistoryReview,Long> {

    List<DeviceHistoryReview> findAllByDeviceId(Long id);
}

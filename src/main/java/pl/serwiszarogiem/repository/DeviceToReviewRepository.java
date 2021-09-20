package pl.serwiszarogiem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.DeviceToReview;

import java.util.List;

@Repository
public interface DeviceToReviewRepository extends JpaRepository<DeviceToReview, Long> {

    List<DeviceToReview> findAllByUserEmail(String email);
}

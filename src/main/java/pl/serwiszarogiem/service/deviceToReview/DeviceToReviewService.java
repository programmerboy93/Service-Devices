package pl.serwiszarogiem.service.deviceToReview;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.DeviceToReview;
import pl.serwiszarogiem.entity.User;

import java.util.List;

@Service
public interface DeviceToReviewService {
    void save(Long id, User user);

    List<DeviceToReview> findAllByUserEmail(String email);

    DeviceToReview findById(Long id);

    List<DeviceToReview> findAll();

    void deleteById(Long id);
}

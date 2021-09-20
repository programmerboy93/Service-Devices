package pl.serwiszarogiem.service.deviceHistoryReview;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.dto.DeviceToReviewDto;
import pl.serwiszarogiem.entity.DeviceHistoryReview;

import java.util.List;

@Service
public interface DeviceHistoryReviewService {
    void save(DeviceToReviewDto deviceToReviewDto);

    List<DeviceHistoryReview> findAllByDeviceId(Long id);
}

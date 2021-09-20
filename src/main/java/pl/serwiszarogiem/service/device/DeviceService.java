package pl.serwiszarogiem.service.device;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Device;

import java.util.List;

@Service
public interface DeviceService {
    List<Device> findAll();

    List<Device> findAllByTypeDevicesId(Long id);

    List<Device> findAllDeviceToReview7DaysWithoutDeviceToReview();

    List<Device> findAllByOrderByReviewToAsc();

    Device findById(Long id);

    void save(pl.serwiszarogiem.entity.Device device);

    void deleteById(Long id);
}

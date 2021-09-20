package pl.serwiszarogiem.service.deviceToReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import pl.serwiszarogiem.entity.Device;
import pl.serwiszarogiem.entity.DeviceToReview;
import pl.serwiszarogiem.entity.User;
import pl.serwiszarogiem.repository.DeviceRepository;
import pl.serwiszarogiem.repository.DeviceToReviewRepository;
import pl.serwiszarogiem.repository.UserRepository;

import java.util.List;


@Primary
@Controller
public class DaoDeviceToReviewService implements DeviceToReviewService{

    private final DeviceToReviewRepository deviceToReviewRepository;
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    @Autowired
    public DaoDeviceToReviewService(DeviceToReviewRepository deviceToReviewRepository, DeviceRepository deviceRepository, UserRepository userRepository) {
        this.deviceToReviewRepository = deviceToReviewRepository;
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(Long id, User user) {
        Device device = deviceRepository.findById(id).get();
        DeviceToReview deviceToReview = new DeviceToReview();
        deviceToReview.setDevice(device);
        deviceToReview.setUser(user);
        deviceToReviewRepository.save(deviceToReview);
    }

    @Override
    public List<DeviceToReview> findAllByUserEmail(String email) {
        return deviceToReviewRepository.findAllByUserEmail(email);
    }

    @Override
    public DeviceToReview findById(Long id) {
        return deviceToReviewRepository.findById(id).get();
    }

    @Override
    public List<DeviceToReview> findAll() {
        return deviceToReviewRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        deviceToReviewRepository.deleteById(id);
    }
}

package pl.serwiszarogiem.service.deviceHistoryReview;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.serwiszarogiem.dto.DeviceToReviewDto;
import pl.serwiszarogiem.entity.DeviceHistoryReview;
import pl.serwiszarogiem.entity.DeviceToReview;
import pl.serwiszarogiem.repository.DeviceHistoryReviewRepository;
import pl.serwiszarogiem.repository.DeviceToReviewRepository;

import javax.transaction.Transactional;
import java.util.List;

@Primary
@Component
public class DaoDeviceHistoryReviewService implements DeviceHistoryReviewService{

    private final DeviceHistoryReviewRepository deviceHistoryReviewRepository;
    private final DeviceToReviewRepository deviceToReviewRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public DaoDeviceHistoryReviewService(DeviceHistoryReviewRepository deviceHistoryReviewRepository, DeviceToReviewRepository deviceToReviewRepository, ModelMapper modelMapper) {
        this.deviceHistoryReviewRepository = deviceHistoryReviewRepository;
        this.deviceToReviewRepository = deviceToReviewRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void save(DeviceToReviewDto deviceToReviewDto) {
        DeviceToReview deviceToReview = deviceToReviewRepository.findById(deviceToReviewDto.getIdReview()).get();

//        deviceHistoryReview.setDevice(deviceToReview.getDevice());
//        deviceHistoryReview.setUser(deviceToReview.getUser());
//        deviceHistoryReview.setStatus(deviceReviewDto.getStatus());
//        deviceHistoryReview.setReviewTo(deviceReviewDto.getReviewTo());
//        deviceHistoryReview.setLastReview(deviceReviewDto.getLastReview());

        DeviceHistoryReview deviceHistoryReview = modelMapper.map(deviceToReviewDto, DeviceHistoryReview.class);

        deviceHistoryReview.getDevice().setReviewTo(deviceToReviewDto.getReviewTo());
        deviceHistoryReview.getDevice().setLastReview(deviceToReviewDto.getLastReview());

        deviceHistoryReviewRepository.save(deviceHistoryReview);
        deviceToReviewRepository.delete(deviceToReview);
    }
    @Override
    public List<DeviceHistoryReview> findAllByDeviceId(Long id) {
        return deviceHistoryReviewRepository.findAllByDeviceId(id);
    }
}

package pl.serwiszarogiem.service.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.serwiszarogiem.entity.Device;
import pl.serwiszarogiem.repository.DeviceRepository;
import pl.serwiszarogiem.repository.ShopRepository;
import pl.serwiszarogiem.repository.TypeDeviceRepository;
import pl.serwiszarogiem.service.deviceToRepair.DaoDeviceToRepairService;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Primary
public class DaoDeviceService implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final TypeDeviceRepository typeDeviceRepository;
    private final ShopRepository shopRepository;
    private final DaoDeviceToRepairService deviceToRepairService;
    @Autowired
    public DaoDeviceService(DeviceRepository deviceRepository, TypeDeviceRepository typeDeviceRepository,
                            ShopRepository shopRepository, DaoDeviceToRepairService deviceToRepairService) {
        this.deviceRepository = deviceRepository;
        this.typeDeviceRepository = typeDeviceRepository;
        this.shopRepository = shopRepository;
        this.deviceToRepairService = deviceToRepairService;
    }

    @Override
    public List<pl.serwiszarogiem.entity.Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public List<pl.serwiszarogiem.entity.Device> findAllByTypeDevicesId(Long id) {
        return deviceRepository.findAllByTypeDevices(typeDeviceRepository.findById(id));
    }

    @Override
    public Device findById(Long id) {
        return deviceRepository.findById(id).get();
    }

    @Override
    public void save(pl.serwiszarogiem.entity.Device device) {
        deviceRepository.save(device);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public List<pl.serwiszarogiem.entity.Device> findAllDeviceToReview7DaysWithoutDeviceToReview() {
        return deviceRepository.findAllDeviceToReview7DaysWithoutDeviceToReview();
    }

    @Override
    public List<pl.serwiszarogiem.entity.Device> findAllByOrderByReviewToAsc() {
        return deviceRepository.findAllByOrderByReviewToAsc();
    }
}

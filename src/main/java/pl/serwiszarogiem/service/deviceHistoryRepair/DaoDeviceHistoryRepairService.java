package pl.serwiszarogiem.service.deviceHistoryRepair;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.serwiszarogiem.dto.DeviceHistoryRepairDto;
import pl.serwiszarogiem.entity.DeviceHistoryRepair;
import pl.serwiszarogiem.repository.DeviceHistoryRepository;
import pl.serwiszarogiem.repository.DeviceToRepairRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class DaoDeviceHistoryRepairService implements DeviceHistoryRepairService {

    private final DeviceHistoryRepository deviceHistoryRepository;
    private final DeviceToRepairRepository deviceToRepairRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public DaoDeviceHistoryRepairService(DeviceHistoryRepository deviceHistoryRepository, DeviceToRepairRepository deviceToRepairRepository, ModelMapper modelMapper) {
        this.deviceHistoryRepository = deviceHistoryRepository;
        this.deviceToRepairRepository = deviceToRepairRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void save(DeviceHistoryRepairDto deviceHistoryRepairDto) {
        DeviceHistoryRepair deviceHistory = modelMapper.map(deviceHistoryRepairDto,DeviceHistoryRepair.class);
        deviceHistory.setDataRepair(LocalDate.now());

        deviceToRepairRepository.deleteById(deviceHistoryRepairDto.getIdRepair());
        deviceHistoryRepository.save(deviceHistory);
    }
    @Override
    public List<DeviceHistoryRepair> findAllByDeviceId(Long id) {

        List<DeviceHistoryRepair> deviceHistories = deviceHistoryRepository.findAllByDeviceId(id);
        return deviceHistories;
    }
}

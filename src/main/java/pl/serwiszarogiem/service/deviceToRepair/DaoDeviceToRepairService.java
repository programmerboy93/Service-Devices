package pl.serwiszarogiem.service.deviceToRepair;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import pl.serwiszarogiem.dto.DeviceToRepairDto;
import pl.serwiszarogiem.entity.DeviceToRepair;
import pl.serwiszarogiem.entity.User;
import pl.serwiszarogiem.repository.DeviceToRepairRepository;

import java.util.List;

@Primary
@Controller
public class DaoDeviceToRepairService implements DeviceToRepairService {

    private final DeviceToRepairRepository deviceToRepairRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public DaoDeviceToRepairService(DeviceToRepairRepository deviceToRepairRepository, ModelMapper modelMapper) {
        this.deviceToRepairRepository = deviceToRepairRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DeviceToRepair> findAll() {
        return deviceToRepairRepository.findAll();
    }

    @Override
    public void save(DeviceToRepairDto deviceToRepairDto) {
        //DeviceToRepair deviceToRepair = modelMapper.map(deviceToRepairDto,DeviceToRepair.class);
        DeviceToRepair deviceToRepair = new DeviceToRepair();
        deviceToRepair.setDevice(deviceToRepairDto.getDevice());
        deviceToRepair.setDescriptionFault(deviceToRepairDto.getDescriptionFault());
        deviceToRepairRepository.save(deviceToRepair);
    }

    @Override
    public DeviceToRepair findById(Long id) {
        return deviceToRepairRepository.findById(id).get();
    }

    @Override
    public void update(Long id, User user) {
        deviceToRepairRepository.update(id, user);
    }

    @Override
    public void delete(DeviceToRepair deviceToRepair) {
        deviceToRepairRepository.delete(deviceToRepair);
    }

    @Override
    public void deleteById(Long id) {
        deviceToRepairRepository.deleteById(id);
    }

    @Override
    public List<DeviceToRepair> findAllByUserEmail(String email) {
        return deviceToRepairRepository.findAllByUserEmail(email);
    }

    @Override
    public List<DeviceToRepair> findByDeviceId(Long id) {
        return deviceToRepairRepository.findByDeviceId(id);
    }
}

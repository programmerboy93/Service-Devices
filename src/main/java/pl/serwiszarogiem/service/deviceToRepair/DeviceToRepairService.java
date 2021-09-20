package pl.serwiszarogiem.service.deviceToRepair;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.dto.DeviceToRepairDto;
import pl.serwiszarogiem.entity.DeviceToRepair;
import pl.serwiszarogiem.entity.User;

import java.util.List;

@Service
public interface DeviceToRepairService {
    List<DeviceToRepair> findAll();

    void save(DeviceToRepairDto deviceToRepairDto);

    DeviceToRepair findById(Long id);

    void update(Long id, User user);

    void delete(DeviceToRepair deviceToRepair);

    void deleteById(Long id);

    List<DeviceToRepair> findAllByUserEmail(String email);

    List<DeviceToRepair> findByDeviceId(Long id);
}

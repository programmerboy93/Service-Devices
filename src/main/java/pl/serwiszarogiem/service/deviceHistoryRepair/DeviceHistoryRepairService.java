package pl.serwiszarogiem.service.deviceHistoryRepair;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.dto.DeviceHistoryRepairDto;
import pl.serwiszarogiem.entity.DeviceHistoryRepair;

import java.util.List;

@Service
public interface DeviceHistoryRepairService {
    List<DeviceHistoryRepair> findAllByDeviceId(Long id);

    void save(DeviceHistoryRepairDto deviceHistoryRepairDto);
}

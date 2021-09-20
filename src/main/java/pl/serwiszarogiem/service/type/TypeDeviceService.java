package pl.serwiszarogiem.service.type;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.TypeDevices;

import java.util.List;

@Service
public interface TypeDeviceService {
    List<TypeDevices> findAll();
}

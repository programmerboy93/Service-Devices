package pl.serwiszarogiem.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.TypeDevices;
import pl.serwiszarogiem.repository.TypeDeviceRepository;

import java.util.List;

@Component
@Primary
public class DaoTypeDeviceService implements TypeDeviceService{

    private final TypeDeviceRepository typeDeviceRepository;
    @Autowired
    public DaoTypeDeviceService(TypeDeviceRepository typeDeviceRepository) {
        this.typeDeviceRepository = typeDeviceRepository;
    }
    @Override
    public List<TypeDevices> findAll() {
        return typeDeviceRepository.findAll();
    }
}

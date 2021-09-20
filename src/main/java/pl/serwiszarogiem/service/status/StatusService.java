package pl.serwiszarogiem.service.status;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Status;

import java.util.List;

@Service
public interface StatusService {
    List<Status> findAll();
}

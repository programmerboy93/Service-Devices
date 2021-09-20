package pl.serwiszarogiem.service.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Status;
import pl.serwiszarogiem.repository.StatusRepository;

import java.util.List;

@Component
@Primary
public class DaoStatusService implements StatusService{

    private final StatusRepository statusRepository;
    @Autowired
    public DaoStatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}

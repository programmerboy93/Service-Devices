package pl.serwiszarogiem.service.owner;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Owner;

import java.util.List;

@Service
public interface OwnerService {
    List<Owner> findAll();
}

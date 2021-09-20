package pl.serwiszarogiem.service.owner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Owner;
import pl.serwiszarogiem.repository.OwnerRepository;

import java.util.List;

@Component
@Primary
public class DaoOwnerService implements OwnerService{

    private final OwnerRepository ownerRepository;
    @Autowired
    public DaoOwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> findAll() {
        List<Owner> owners = ownerRepository.findAll();
        owners.stream().forEach(o-> o.getShopList().size());
        return owners;
    }
}

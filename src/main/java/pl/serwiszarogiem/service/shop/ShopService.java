package pl.serwiszarogiem.service.shop;

import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Owner;
import pl.serwiszarogiem.entity.Shop;

import java.util.List;
@Service
public interface ShopService {

    List<Shop> findByOwner(Owner owner);
    List<Shop> findAll();
    List<Shop> findAllByOwner(Long id);
    Shop findById(Long id);
}

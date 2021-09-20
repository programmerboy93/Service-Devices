package pl.serwiszarogiem.service.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.serwiszarogiem.entity.Owner;
import pl.serwiszarogiem.entity.Shop;
import pl.serwiszarogiem.repository.OwnerRepository;
import pl.serwiszarogiem.repository.ShopRepository;

import java.util.List;

@Component
@Primary
public class DaoShopService implements ShopService{

    private final ShopRepository shopRepository;
    private final OwnerRepository ownerRepository;
    @Autowired
    public DaoShopService(ShopRepository shopRepository, OwnerRepository ownerRepository) {
        this.shopRepository = shopRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Shop> findByOwner(Owner owner) {
        return shopRepository.findAllByOwner(owner);
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> findAllByOwner(Long id) {
        return shopRepository.findAllByOwnerId(id);
    }

    @Override
    public Shop findById(Long id) {
        Shop shop = shopRepository.findById(id).get();
        shop.getDevices().size();
        return shop;
    }
}

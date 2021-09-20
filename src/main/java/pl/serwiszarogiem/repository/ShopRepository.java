package pl.serwiszarogiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.serwiszarogiem.entity.Owner;
import pl.serwiszarogiem.entity.Shop;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {
    List<Shop> findAllByOwner(Owner owner);

    List<Shop> findAllByOwnerId(Long id);
}

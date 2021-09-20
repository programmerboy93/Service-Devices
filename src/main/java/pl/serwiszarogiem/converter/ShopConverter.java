package pl.serwiszarogiem.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.serwiszarogiem.entity.Shop;
import pl.serwiszarogiem.service.shop.DaoShopService;
import pl.serwiszarogiem.service.shop.ShopService;

@Component
public class ShopConverter implements Converter<String, Shop> {

    @Autowired
    private ShopService shopService;

    @Override
    public Shop convert(String id) {
        return shopService.findById(Long.parseLong(id));
    }
}

package pl.serwiszarogiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.serwiszarogiem.service.shop.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;
    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("shops",shopService.findAll());
        return "users/shop/listShop";
    }

    @GetMapping("/allByOwner/{id}")
    public String allByOwner(@PathVariable Long id, Model model){
        model.addAttribute("shops",shopService.findAllByOwner(id));
        return "users/shop/listShop";
    }
}

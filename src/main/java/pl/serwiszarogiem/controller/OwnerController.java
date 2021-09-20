package pl.serwiszarogiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.serwiszarogiem.service.owner.OwnerService;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "users/owner/listOwner";
    }
}

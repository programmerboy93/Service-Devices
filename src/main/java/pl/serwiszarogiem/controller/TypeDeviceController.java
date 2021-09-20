package pl.serwiszarogiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.serwiszarogiem.service.type.TypeDeviceService;

@Controller
@RequestMapping("/typeDevice")
public class TypeDeviceController {

    private final TypeDeviceService typeDeviceService;
    @Autowired
    public TypeDeviceController(TypeDeviceService typeDeviceService) {
        this.typeDeviceService = typeDeviceService;
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("typeDevices",typeDeviceService.findAll());
        return "users/typeDevice/listTypeDevice";
    }
}

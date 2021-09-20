package pl.serwiszarogiem.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.serwiszarogiem.entity.*;
import pl.serwiszarogiem.service.device.DeviceService;
import pl.serwiszarogiem.service.deviceHistoryRepair.DeviceHistoryRepairService;
import pl.serwiszarogiem.service.deviceHistoryReview.DeviceHistoryReviewService;
import pl.serwiszarogiem.service.deviceToRepair.DeviceToRepairService;
import pl.serwiszarogiem.service.shop.ShopService;
import pl.serwiszarogiem.service.type.TypeDeviceService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/device")
@Log4j2
public class DeviceController {

    private final DeviceService deviceService;
    private final ShopService shopService;
    private final TypeDeviceService typeDeviceService;
    private final DeviceToRepairService deviceToRepairService;
    private final DeviceHistoryRepairService deviceHistoryService;
    private final DeviceHistoryReviewService deviceHistoryReviewService;

    @Autowired
    public DeviceController(DeviceService deviceService,
                            ShopService shopService,
                            TypeDeviceService typeDeviceService,
                            DeviceToRepairService deviceToRepairService,
                            DeviceHistoryRepairService deviceHistoryRepairService,
                            DeviceHistoryReviewService deviceHistoryReviewService) {
        this.deviceService = deviceService;
        this.shopService = shopService;
        this.typeDeviceService = typeDeviceService;
        this.deviceToRepairService = deviceToRepairService;
        this.deviceHistoryService = deviceHistoryRepairService;
        this.deviceHistoryReviewService = deviceHistoryReviewService;
    }

    @GetMapping("/all")
    public String all( Model model) {
        model.addAttribute("devices", deviceService.findAllByOrderByReviewToAsc());
        return "users/device/listDevice";
    }

    @GetMapping("/byType/{id}")
    public String byType(@PathVariable Long id, Model model) {
        model.addAttribute("devices", deviceService.findAllByTypeDevicesId(id));
        return "users/device/listDevice";
    }

    @GetMapping("/add")
    public String displayFormCreateDevice(Long id, Model model){
        Device device;
        if(id != null){
            device = deviceService.findById(id);
        } else {
            device = new Device();
        }
        model.addAttribute("device",device);
        return "users/device/addDevice";
    }

    @PostMapping("/add")
    public String add(@Valid Device device, BindingResult result,Model model){
        if(result.hasErrors()){
            return "users/device/addDevice";
        }

        deviceService.save(device);
        model.addAttribute("msg","Dodano urządzenie do bazy danych");
        return "users/displayMessage";
    }


    @GetMapping("/byShop/{id}")
    public String allDeviceInShop(@PathVariable Long id, Model model) {
        model.addAttribute("shop", shopService.findById(id));
        return "users/shop/shopAndListDevices";
    }

    @GetMapping("/delete/{id}")
    public String deleteDevice(@PathVariable Long id, Model model){
        if(deviceToRepairService.findByDeviceId(id)==null) {
            deviceService.deleteById(id);
            model.addAttribute("msg", "Usunięto urządzenie z bazy danych");
        }
        return "redirect:/device/all";
    }

    @GetMapping("/historyDevice/{id}")
    public String historyDevice(@PathVariable Long id,Model model){
        List<DeviceHistoryRepair> deviceHistories = deviceHistoryService.findAllByDeviceId(id);
        List<DeviceHistoryReview> deviceHistoryReviews = deviceHistoryReviewService.findAllByDeviceId(id);
        if(deviceHistories.size()==0 && deviceHistoryReviews.size()==0){
            model.addAttribute("msg","Brak wpisów dla danego urządzenia");
            return "users/displayMessage";
        }
        model.addAttribute("deviceHistoryReviews", deviceHistoryReviews);
        model.addAttribute("deviceHistory",deviceHistories);
        return "users/device/historyDevice";
    }

    @ModelAttribute("shops")
    public List<Shop> shops(){
        return shopService.findAll();
    }

    @ModelAttribute("typeDevices")
    public List<TypeDevices> typeDevices(){
        return typeDeviceService.findAll();
    }
}

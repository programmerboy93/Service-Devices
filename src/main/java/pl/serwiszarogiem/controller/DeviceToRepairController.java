package pl.serwiszarogiem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.serwiszarogiem.dto.DeviceHistoryRepairDto;
import pl.serwiszarogiem.dto.DeviceToRepairDto;
import pl.serwiszarogiem.entity.Device;
import pl.serwiszarogiem.entity.DeviceToRepair;
import pl.serwiszarogiem.entity.Status;
import pl.serwiszarogiem.entity.User;
import pl.serwiszarogiem.service.device.DeviceService;
import pl.serwiszarogiem.service.deviceHistoryRepair.DeviceHistoryRepairService;
import pl.serwiszarogiem.service.deviceToRepair.DeviceToRepairService;
import pl.serwiszarogiem.service.status.StatusService;
import pl.serwiszarogiem.service.user.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/deviceToRepair")
public class DeviceToRepairController {

    private final DeviceToRepairService deviceToRepairService;
    private final UserService userService;
    private final DeviceService deviceService;
    private final StatusService statusService;
    private final DeviceHistoryRepairService deviceHistoryRepairService;
    private final ModelMapper modelMapper;
    @Autowired
    public DeviceToRepairController(DeviceToRepairService deviceToRepairService,
                                    UserService userService,
                                    DeviceService deviceService,
                                    StatusService statusService,
                                    DeviceHistoryRepairService deviceHistoryRepairService,
                                    ModelMapper modelMapper) {
        this.deviceToRepairService = deviceToRepairService;
        this.userService = userService;
        this.deviceService = deviceService;
        this.statusService = statusService;
        this.deviceHistoryRepairService = deviceHistoryRepairService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("devicesToRepair",deviceToRepairService.findAll());
        return "users/deviceToRepair/listDeviceToRepair";
    }


    @PostMapping("/addUser")
    public String addUser(@RequestParam Long id, Principal principal){
        DeviceToRepair deviceToRepair = deviceToRepairService.findById(id);
        User user = userService.findByEmailIgnoreCase(principal.getName());
        deviceToRepairService.update(deviceToRepair.getId(),user);
        return "redirect:/deviceToRepair/all";
    }

    @PostMapping("/changeUser")
    public String changeUser(@RequestParam Long deviceId,@RequestParam Long userId){
        DeviceToRepair deviceToRepair = deviceToRepairService.findById(deviceId);
        User user = userService.findById(userId);
        deviceToRepairService.update(deviceToRepair.getId(),user);
        return "redirect:/deviceToRepair/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        deviceToRepairService.deleteById(id);
        return "redirect:/deviceToRepair/all";
    }

    @GetMapping("/myDeviceToRepair")
    public String deviceUser(Model model,Principal principal){
        model.addAttribute("devicesToRepair",deviceToRepairService.findAllByUserEmail(principal.getName()));
        return "users/deviceToRepair/myListDeviceToRepair";
    }

    @GetMapping("/add/{id}")
    public String addDeviceToRepair(@PathVariable Long id, Model model){
        Device device = deviceService.findById(id);
        DeviceToRepairDto deviceToRepairDto = new DeviceToRepairDto();
        deviceToRepairDto.setDevice(device);

        model.addAttribute("deviceToRepairDto",deviceToRepairDto);
        return "users/deviceToRepair/addDeviceToRepair";
    }

    @PostMapping("/add")
    public String  addDeviceToRepair(@Valid DeviceToRepairDto deviceToRepairDto, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "users/deviceToRepair/addDeviceToRepair";
        }

        deviceToRepairService.save(deviceToRepairDto);
        model.addAttribute("msg","Zapisano zgłoszenie o uszkodzonym urządzeniu");
        return "users/deviceToRepair/addDeviceToRepair";
    }

    @GetMapping("/addDescriptionRepair/{id}")
    public String addDescriptionRepair(@PathVariable Long id, Model model){
        DeviceToRepair deviceToRepair = deviceToRepairService.findById(id);

        DeviceHistoryRepairDto deviceHistoryRepairDto = modelMapper.map(deviceToRepair, DeviceHistoryRepairDto.class);
        deviceHistoryRepairDto.setDescriptionRepair(null);


        model.addAttribute("deviceHistoryRepairDto", deviceHistoryRepairDto);
        return "users/deviceToRepair/addDescriptionRepair";
    }

    @PostMapping("/addDescriptionRepair")
    public String addDescriptionRepair(@Valid DeviceHistoryRepairDto deviceHistoryRepairDto, BindingResult result){
        if(result.hasErrors()){
            return "users/deviceToRepair/addDescriptionRepair";
        }

        deviceHistoryRepairService.save(deviceHistoryRepairDto);
        return "redirect:/deviceToRepair/myDeviceToRepair";
    }
    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAllUser();
    }

    @ModelAttribute("statuses")
    public List<Status> statuses(){
        return statusService.findAll();
    }
}

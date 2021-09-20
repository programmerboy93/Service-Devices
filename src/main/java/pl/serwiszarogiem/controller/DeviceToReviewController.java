package pl.serwiszarogiem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.serwiszarogiem.dto.DeviceToReviewDto;
import pl.serwiszarogiem.entity.DeviceToReview;
import pl.serwiszarogiem.entity.Status;
import pl.serwiszarogiem.service.device.DeviceService;
import pl.serwiszarogiem.service.deviceHistoryReview.DeviceHistoryReviewService;
import pl.serwiszarogiem.service.deviceToReview.DeviceToReviewService;
import pl.serwiszarogiem.service.status.StatusService;
import pl.serwiszarogiem.service.user.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/deviceToReview")
public class DeviceToReviewController {

    private final DeviceService deviceService;
    private final DeviceToReviewService deviceToReviewService;
    private final UserService userService;
    private final DeviceHistoryReviewService deviceHistoryReviewService;
    private final StatusService statusService;
    private final ModelMapper modelMapper;
    @Autowired
    public DeviceToReviewController(DeviceService deviceService,
                                    DeviceToReviewService deviceToReviewService,
                                    UserService userService,
                                    DeviceHistoryReviewService deviceHistoryReviewService,
                                    StatusService statusService,
                                    ModelMapper modelMapper) {
        this.deviceService = deviceService;
        this.deviceToReviewService = deviceToReviewService;
        this.userService = userService;
        this.deviceHistoryReviewService = deviceHistoryReviewService;
        this.statusService = statusService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("devicesToReview", deviceService.findAllDeviceToReview7DaysWithoutDeviceToReview());
        return "users/deviceToReview/listDeviceToReview";
    }

    @GetMapping("/addDeviceToUser/{id}")
    public String add(@PathVariable Long id, Principal principal){
        deviceToReviewService.save(id,userService.findByEmailIgnoreCase(principal.getName()));
        return "redirect:/deviceToReview/all";
    }

    @GetMapping("/myDeviceToReview")
    public String myDeviceToReview(Model model,Principal principal){
        model.addAttribute("devicesToReview", deviceToReviewService.findAllByUserEmail(principal.getName()));
        return "users/deviceToReview/myListDeviceToReview";
    }

    @GetMapping("/deviceAfterReview/{id}")
    public String deviceAfterReview(@PathVariable Long id, Model model){
        DeviceToReview deviceToReview = deviceToReviewService.findById(id);
        DeviceToReviewDto deviceToReviewDto = new DeviceToReviewDto();

        deviceToReviewDto.setDevice(deviceToReview.getDevice());
        deviceToReviewDto.setIdReview(deviceToReview.getId());

        model.addAttribute("deviceReviewDto", deviceToReviewDto);
        return "users/deviceToReview/deviceAfterReview";
    }

    @PostMapping("/deviceAfterReview")
    public String deviceAfterReview(@ModelAttribute(value = "deviceReviewDto")@Valid DeviceToReviewDto deviceToReviewDto,
                                    BindingResult result){
        if(result.hasErrors()){
            return "users/deviceToReview/deviceAfterReview";
        }
        deviceHistoryReviewService.save(deviceToReviewDto);
        return "redirect:/deviceToReview/myDeviceToReview";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id){
        deviceToReviewService.deleteById(id);
        return "redirect:/deviceToReview/myDeviceToReview";
    }

    @ModelAttribute("statuses")
    public List<Status> statuses(){
        return statusService.findAll();
    }
}

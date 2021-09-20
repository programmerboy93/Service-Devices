package pl.serwiszarogiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.serwiszarogiem.service.status.StatusService;

@Controller
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;
    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
}

package pl.serwiszarogiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.serwiszarogiem.security.CustomUserDetails;
import pl.serwiszarogiem.service.user.UserService;

@Controller
@RequestMapping("/test")
public class HelloController {

    private final UserService userService;
    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    @ResponseBody
    public String hello(@AuthenticationPrincipal CustomUserDetails user){
        return user.getUsername();
    }
}

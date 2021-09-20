package pl.serwiszarogiem.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.serwiszarogiem.entity.User;
import pl.serwiszarogiem.service.email.EmailService;
import pl.serwiszarogiem.service.token.TokenService;
import pl.serwiszarogiem.service.user.UserService;

import javax.mail.MessagingException;
import java.util.List;

@Controller

@RequestMapping("/panelSettings")
@Log4j2
public class SettingController {

    private final EmailService emailService;
    private final UserService userService;
    private final TokenService tokenService;
    @Autowired
    public SettingController(EmailService emailService,
                             UserService userService,
                             TokenService tokenService) {
        this.emailService = emailService;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public String displaySettings() {
        return "users/settings/settings";
    }

    @GetMapping("/user/deactive/{id}")
    public String delete(@PathVariable Long id){
        User user = userService.findById(id);
        user.setEnabled(!user.isEnabled());
        userService.save(user);
        return "redirect:/panelSettings";
    }

    @PostMapping("/sendTokenToUser")
    public String sendTokenToUser(@RequestParam String email, Model model) throws MessagingException {
        model.addAttribute("msg",emailService.sendMailWithNewToken(email));
        return "users/settings/settings";
    }

    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAllUser();
    }

}

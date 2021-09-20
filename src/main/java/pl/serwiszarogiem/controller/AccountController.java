package pl.serwiszarogiem.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.serwiszarogiem.dto.NewPasswordDto;
import pl.serwiszarogiem.dto.UserDto;
import pl.serwiszarogiem.service.email.EmailService;
import pl.serwiszarogiem.entity.Token;
import pl.serwiszarogiem.service.token.TokenService;
import pl.serwiszarogiem.service.user.UserService;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
@Log4j2
public class AccountController {

    private final UserService userService;
    private final TokenService tokenService;
    private final EmailService emailService;
    @Autowired
    public AccountController(UserService userService,
                             TokenService tokenService,
                             EmailService emailService) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.emailService = emailService;
    }

    @GetMapping({"/login",""})
    public String displayFormLogin() {
        return "account/login";
    }

    @GetMapping("/register/{token}")
    public String checkTokenIsDatabase(@PathVariable String token, Model model) {
        if (tokenService.findByToken(token) != null) {
            Token token1 = tokenService.findByToken(token);
            UserDto userDto = new UserDto();
            userDto.setEmail(token1.getEmail());
            model.addAttribute("user", userDto);
            return "account/register";
        } else
            return "redirect:/login";
    }

    @PostMapping("/register")
    public String process_register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result) {
        if (userService.EmailExistsValidator(userDto, result)) {
            return "account/register";
        }

        userService.createAccount(userDto);
        tokenService.delete(userDto.getEmail());
        return "account/register_success";
    }

    @GetMapping("/forgotPassword")
    public String displayFormForgotPassword() {
        return "account/forgotPassword";
    }

    @GetMapping("/forgotPassword/{token}")
    public String displayFormCreateNewPassword(@PathVariable String token, Model model) {
        if (tokenService.findByToken(token) != null) {
            NewPasswordDto newPasswordDto = new NewPasswordDto();
            newPasswordDto.setEmail(tokenService.findByToken(token).getEmail());
            model.addAttribute("newPassword", newPasswordDto);
            return "account/newPassword";
        } else
            return "redirect:/login";
    }

    @PostMapping("/saveNewPassword")
    public String saveNewPassword(@Valid @ModelAttribute("newPassword") NewPasswordDto password, BindingResult result, Model model) {
        if(!password.getPassword().equals(password.getMatchingPassword())){
            result.rejectValue("matchingPassword", "newPassword.matchingPassword", "Popraw hasła");
            return "account/newPassword";
        }
        userService.saveNewPassword(password);
        model.addAttribute("msg", "Zmieniono hasło w bazie danych");
        return "account/newPassword";
    }

    @PostMapping("/forgotPassword")
    public String sendEmailWithUrlToNewPassword(@RequestParam String email, Model model) throws MessagingException {
        model.addAttribute("msg",emailService.sendMailWithNewPassword(email));
        return "account/forgotPassword";
    }
}

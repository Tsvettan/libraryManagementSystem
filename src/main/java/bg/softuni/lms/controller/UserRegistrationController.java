package bg.softuni.lms.controller;

import bg.softuni.lms.model.dto.ReCaptchaResponseDto;
import bg.softuni.lms.model.dto.UserRegistrationDto;
import bg.softuni.lms.service.ReCaptchaService;
import bg.softuni.lms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;
    private final ReCaptchaService reCaptchaService;

    public UserRegistrationController(UserService userService, ReCaptchaService reCaptchaService) {
        this.userService = userService;
        this.reCaptchaService = reCaptchaService;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDto userRegistrationDto,
                           @RequestParam("g-recaptcha-response") String reCaptchaResponse) {

        boolean isBot = !reCaptchaService
                .verify(reCaptchaResponse)
                .map(ReCaptchaResponseDto::isSuccess)
                .orElse(false);

        if (isBot) {
            return "redirect:/";
        }

        userService.registerUser(userRegistrationDto);

        return "redirect:/";
    }
}

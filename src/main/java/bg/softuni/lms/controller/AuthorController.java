package bg.softuni.lms.controller;

import bg.softuni.lms.model.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/registration")
//    public String registrationForm(Model model) {
////        model.addAttribute("user", new UserDto());
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("user") @Valid UserDto userDto,
//                               BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
////        userService.registerNewUser(userDto);
//        return "redirect:/login?registrationSuccess";
//    }
//
//    @GetMapping("/welcome")
//    public String welcome() {
//        return "welcome";
//    }

    @GetMapping("/authors")
    public String allAuthors() {
        return "authors";
    }
}

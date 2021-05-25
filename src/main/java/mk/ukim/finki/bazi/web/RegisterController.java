package mk.ukim.finki.bazi.web;

import mk.ukim.finki.bazi.model.Role;
import mk.ukim.finki.bazi.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.bazi.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.bazi.model.exceptions.UsernameExistsException;
import mk.ukim.finki.bazi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent","register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam Role role,
                           Model model) {
        try {
            this.userService.register(username, password, role);
            return "redirect:/login";
        }  catch (UsernameExistsException | InvalidArgumentsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("bodyContent", "register");
            return "master-template";
        }
    }

}

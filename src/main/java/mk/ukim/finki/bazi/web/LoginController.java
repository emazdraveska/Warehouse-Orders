package mk.ukim.finki.bazi.web;

import mk.ukim.finki.bazi.model.MagacinEntity;
import mk.ukim.finki.bazi.model.ProdavnicaMaloprodazhbaEntity;
import mk.ukim.finki.bazi.model.User;
import mk.ukim.finki.bazi.model.exceptions.InvalidCredentialsException;
import mk.ukim.finki.bazi.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @GetMapping( "/error")
    public String getLoginPage(Model model, InvalidCredentialsException exception) {
        model.addAttribute("hasError", true);
        model.addAttribute("error", exception.getMessage());
        model.addAttribute("bodyContent","login");
        return "master-template";
    }

    @PostMapping()
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        User user = null;

        try {
            user = this.authService.login(username, password);
            model.addAttribute("user", user);
            return "redirect:/home";
        } catch (InvalidCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("bodyContent", "login");
            return "master-template";
        }
    }

}

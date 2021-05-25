package mk.ukim.finki.bazi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home","/"})
public class HomeController {

    @GetMapping
    private String getHomePage (Model model){
        model.addAttribute("bodyContent","home");
        return "master-template";
    }
}

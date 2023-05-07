package fr.simplon.titrev2.controllerClient;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class NavigationController {

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        return "login";
    }
}

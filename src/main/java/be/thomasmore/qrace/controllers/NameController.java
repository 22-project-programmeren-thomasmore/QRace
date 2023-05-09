package be.thomasmore.qrace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// Annotatie om aan te geven dat deze klasse een Spring Controller is
@Controller
// Annotatie om aan te geven welke attributen moeten worden opgeslagen in de sessie
@SessionAttributes("userName")
public class NameController {

    // Methode om het "userName" attribuut toe te voegen aan het Model
    @ModelAttribute("userName")
    public String userName() {
        return "";
    }

    // Methode om te reageren op een GET-verzoek voor "/name"
    @GetMapping("/name")
    public String showNameForm() {
        return "name";
    }

    // Methode om te reageren op een POST-verzoek voor "/name"
    @PostMapping("/name")
    public String handleNameSubmit(@RequestParam("name") String name, Model model) {
        // Voeg de ingevoerde gebruikersnaam toe aan het Model
        model.addAttribute("userName", name);
        // Redirect naar de "/host-join" route
        return "redirect:/host-join";
    }
}

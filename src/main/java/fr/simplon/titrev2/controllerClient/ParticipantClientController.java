package fr.simplon.titrev2.controllerClient;

import fr.simplon.titrev2.model.Evenement;
import fr.simplon.titrev2.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ParticipantClientController {

    private RestTemplate restTemplate;


    @GetMapping("/participants/{username}")
    public String Afficherlisteevenementparticipant(Model model, @PathVariable String username) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8081/rest/particip/{username}";
        ResponseEntity<List<Participant>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Participant>>() {},
                username
        );
        List<Participant> participants = response.getBody();
        model.addAttribute("participants", participants);
        return "listeEvenementsParticipant";
    }


}

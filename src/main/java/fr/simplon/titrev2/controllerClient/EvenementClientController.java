package fr.simplon.titrev2.controllerClient;

import fr.simplon.titrev2.model.Evenement;
import fr.simplon.titrev2.model.Participant;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Controller
public class EvenementClientController {

    private RestTemplate restTemplate;

    @GetMapping("/admin/listeEvenements")
    public String afficherListeEvenementAdmin(Model model){
        this.restTemplate = new RestTemplate();
        String url ="http://localhost:8081/rest/evenements";
        ResponseEntity<List<Evenement>> response=restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Evenement>>(){});

        List<Evenement> evenements = response.getBody();

        model.addAttribute("evenements", evenements);
        return "listeEvenementsAdmin";
    }



    @GetMapping("/programmation")
    public String getAllEvents(Model model) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8081/rest/evenements";
        ResponseEntity<List<Evenement>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Evenement>>() {
                });
        List<Evenement> evenements = response.getBody();
        model.addAttribute("evenements", evenements);
        return "programmation";
    }

    @GetMapping("/api/evenements")
    @ResponseBody
    public List<Evenement> getAllEventsAPI() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<Evenement>> response = restTemplate.exchange("http://localhost:8081/rest/api/evenements", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Evenement>>() {
        });
        return response.getBody();
    }

    @GetMapping("/evenements/{id}")
    public String getEvent(Model model, @PathVariable Long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8081/rest/evenements/{id}";
        ResponseEntity<Evenement> response = restTemplate.getForEntity(url, Evenement.class, id);
        Evenement evenement = response.getBody();
        model.addAttribute("evenement", evenement);
        return "fiche_evenement";
    }

    @GetMapping("/creationEvenement")
    public String displayEventForm(Model model) {
        Evenement evenement = new Evenement();
        model.addAttribute("evenement", evenement);
        return "formulaireEvenement";
    }

    @PostMapping("/creationEvenement")
    public String addEvent(@ModelAttribute("evenement") Evenement evenement) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8081/rest/evenements";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Evenement> request = new HttpEntity<>(evenement, headers);
        ResponseEntity<Evenement> response = restTemplate.postForEntity(url, request, Evenement.class);
        return "redirect:/programmation";
    }

    @GetMapping("/evenements/{id}/participation")
    public String getParticipationForm(Model model, @PathVariable Long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8081/rest/evenements/{id}";
        ResponseEntity<Evenement> response = restTemplate.getForEntity(url, Evenement.class, id);
        Evenement evenement = response.getBody();
        model.addAttribute("evenement", evenement);
        Participant participant = new Participant();
        participant.setEvenement(evenement);
        participant.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("participant", participant);
        return "formulaireParticipation";
    }

    @PostMapping("/evenements/{id}/participation")
    public String addParticipant(@ModelAttribute("participant") Participant participant) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8081/rest/participants";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Participant> request = new HttpEntity<>(participant, headers);
        ResponseEntity<Participant> response = restTemplate.postForEntity(url, request, Participant.class);
        return "redirect:/";
    }

    @GetMapping("/UpdateEvent/{id}")
    public String displayFormModEvent(Model model, @PathVariable Long id){
        this.restTemplate = new RestTemplate();
        String url="http://localhost:8081/rest/evenements/{id}";
        ResponseEntity<Evenement> response = restTemplate.getForEntity(url, Evenement.class, id);
        Evenement evenement = response.getBody();
        model.addAttribute("evenement", evenement);
        return "formulaireModifEvenement";
    }

    @PostMapping("UpdateEvent/{id}")
    public String updateEvent (@ModelAttribute("evenement")Evenement evenement, @PathVariable Long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8081/rest/UpdateEvent/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Evenement> request = new HttpEntity<>(evenement, headers);
        ResponseEntity<Evenement> response = restTemplate.exchange(url, HttpMethod.POST, request, Evenement.class, id);
        return "redirect:/";
    }


    @GetMapping ("evenements/delete/{id}")
    public String delEvent(Model model, @PathVariable Long id){
        this.restTemplate = new RestTemplate();
        String url="http://localhost:8081/rest/evenements/{id}";
        restTemplate.delete(url, id);
        return "redirect:/";
    }
}
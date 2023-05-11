package fr.simplon.titrev2.controllerService;

import fr.simplon.titrev2.model.Evenement;
import fr.simplon.titrev2.model.Organisme;
import fr.simplon.titrev2.model.Participant;
import fr.simplon.titrev2.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ParticipantServiceController {


    @Autowired
    private ParticipantRepository repo;


    @GetMapping(path = "/rest/participants")
    public List<Participant> getAllParticipants() {

        return repo.findAll();
    }


    @GetMapping(path = "/rest/participants/{id}")
    public Participant getparticipantsDetails(@PathVariable Long id)throws NoSuchElementException {
        return repo.findById(id).orElseThrow();
    }


    @PostMapping(path="/rest/participants")
    public Evenement addParticipant(@RequestBody Participant newParticipant) {
        return repo.save(newParticipant).getEvenement();
    }

    @PutMapping("/rest/participants/{id}")
    public Participant updateParticipant(@RequestBody Participant newParticipant, @PathVariable Long id) {
        return repo.findById(id)
                .map(participant -> {
                    participant.setPrenom(newParticipant.getPrenom());
                    participant.setNom(newParticipant.getNom());
                    participant.setTelephone(newParticipant.getTelephone());
                    participant.setEmail(newParticipant.getEmail());
                    participant.setCode_postal(newParticipant.getCode_postal());
                    participant.setEvenement(newParticipant.getEvenement());
                    return repo.save(participant);
                })
                .orElseGet(() -> {
                    newParticipant.setId(id);
                    return repo.save(newParticipant);
                });
    }


    @DeleteMapping("/rest/participants/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        repo.deleteById(id);
    }



    @GetMapping(path = "/rest/particip/{username}")
    public List<Participant> afficherparticipantparusername(@PathVariable String username) {
        return repo.findByUsername(username);
    }


}

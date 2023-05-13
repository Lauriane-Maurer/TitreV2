package fr.simplon.titrev2.repository;

import fr.simplon.titrev2.model.Evenement;
import fr.simplon.titrev2.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long>  {
    List<Participant> findByUsername(String username);


    List<Participant> findByEvenement(Evenement evenement);

}

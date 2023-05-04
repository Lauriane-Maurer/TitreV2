package fr.simplon.titrev2.repository;

import fr.simplon.titrev2.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}

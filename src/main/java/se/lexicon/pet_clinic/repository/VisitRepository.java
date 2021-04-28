package se.lexicon.pet_clinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VisitRepository extends CrudRepository<Visit, String> {
    Optional<Visit> findById(String id);

    List<Visit> findByVisitDate(LocalDate visitDate);

    List<Visit> findByDescription(String description);

    List<Visit> findVisitByPetName(String petName);

    List<Visit> findVisitByPetPetTypeName(String petTypeName);
}

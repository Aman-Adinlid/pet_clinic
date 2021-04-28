package se.lexicon.pet_clinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.PetType;

import java.util.List;
import java.util.Optional;

public interface PetTypeRepository extends CrudRepository<PetType, Integer> {
    Optional<PetType> findById(int id);

    List<PetType> findByName(String name);
}

package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, String> {

    List<Pet> findByName(String name);

    List<Pet> findPetByPetType(PetType petType);

    List<Pet> findPetByOwnerFirstNameAndOwnerLastName(String firstName, String lastName);

    List<Pet> findByOwnerTelephone(String telephone);
}

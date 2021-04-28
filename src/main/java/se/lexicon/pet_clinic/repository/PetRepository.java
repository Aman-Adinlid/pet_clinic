package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Pet;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, String> {

    List<Pet> findByName(String name);

    List<Pet> findByPetTypeName(String petTypeName);

    List<Pet> findPetByOwnerFirstNameAndOwnerLastName(String firstName, String lastName);

    List<Pet> findByOwnerTelephone(String telephone);
}

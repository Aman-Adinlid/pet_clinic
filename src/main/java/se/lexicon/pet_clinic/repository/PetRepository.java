package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, String> {

    List<Pet> findByName(String name);

    List<Pet> findPetByPetTypeName(PetType name);

    List<Pet> findPetByOwnerFirstNameAndOwnerLastName(Owner firstName, Owner lastName);

    List<Pet> findByOwnerTelephone(Owner telephone);
}

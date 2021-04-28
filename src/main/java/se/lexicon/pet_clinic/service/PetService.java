package se.lexicon.pet_clinic.service;

import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.PetType;
import se.lexicon.pet_clinic.exception.DataNotFoundException;

import java.util.List;

public interface PetService {

    PetDto save(PetDto dto);

    PetDto update(PetDto dto) throws DataNotFoundException;

    PetDto findById(String id) throws DataNotFoundException;

    void deleteById(String id);

    List<PetDto> findAll();

    List<PetDto> findByName(String name);

    List<PetDto> findByPetTyeName(String name);

    List<PetDto> findByOwnerFirstNameAndOwnerLastName(String firstName, String lastName);

    List<PetDto> findByOwnerTelephone(String telephone);


}

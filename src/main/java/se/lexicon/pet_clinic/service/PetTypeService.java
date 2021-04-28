package se.lexicon.pet_clinic.service;

import se.lexicon.pet_clinic.dto.PetTypeDto;

import java.util.List;

public interface PetTypeService {

    PetTypeDto save(PetTypeDto dto);

    PetTypeDto update(PetTypeDto dto);

    void delete(int id);

    List<PetTypeDto> findAll();

    PetTypeDto findById(int id);
}

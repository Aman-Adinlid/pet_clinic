package se.lexicon.pet_clinic.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.entity.PetType;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.repository.PetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetTypeServiceImpl implements PetTypeService {
    PetTypeRepository petTypeRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetTypeRepository(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public PetTypeDto save(PetTypeDto dto) {
        if (dto == null) throw new IllegalArgumentException("OwnerDto object should not be null");
        PetType petTypeEntity = modelMapper.map(dto, PetType.class);
        PetType savedPetTypeEntity = petTypeRepository.save(petTypeEntity);
        PetTypeDto convertEntityToDto = modelMapper.map(savedPetTypeEntity, PetTypeDto.class);
        return convertEntityToDto;
    }

    @Override
    public PetTypeDto update(PetTypeDto dto) {
        if (dto == null) throw new IllegalArgumentException("OwnerDto object should not be null");
        Optional<PetType> list = petTypeRepository.findById(dto.getId());
        return modelMapper.map(petTypeRepository.save(modelMapper.map(dto, PetType.class)), PetTypeDto.class);
        // return petTypeRepository.findById(dto.getId()).stream().map(petType -> modelMapper.map(dto,PetType.class)),PetTypeDto.class;
    }

    @Override
    public void delete(int id) {
        if (id == 0) throw new IllegalArgumentException("Id should not be null");
        Optional<PetType> optionalPetType = petTypeRepository.findById(id);
        if (optionalPetType.isPresent()) {
            PetType petTypeEntity = modelMapper.map(optionalPetType, PetType.class);
            petTypeRepository.delete(petTypeEntity);

        }
    }

    @Override
    public List<PetTypeDto> findAll() {
        List<PetType> petTypeList = new ArrayList<>();
        petTypeRepository.findAll().iterator().forEachRemaining(petTypeList::add);
        List<PetTypeDto> petTypeDtoList = petTypeList.stream()
                .map(petType -> modelMapper.map(petType, PetTypeDto.class))
                .collect(Collectors.toList());
        return petTypeDtoList;
    }

    @Override
    public PetTypeDto findById(int id) throws DataNotFoundException {
        if (id == 0) throw new IllegalArgumentException("Id should not be null");
        Optional<PetType> optionalPetType = petTypeRepository.findById(id);
        if (optionalPetType.isPresent()) {
            PetTypeDto covertToDto = modelMapper.map(optionalPetType.get(), PetTypeDto.class);
            return covertToDto;
        } else throw new DataNotFoundException("PetTypeDto not found");

    }


}

package se.lexicon.pet_clinic.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class PetDto {
    private String id;
    private String name;
    private LocalTime birthDate;
    private PetTypeDto petTypeDto;
    private OwnerDto ownerDto;
}

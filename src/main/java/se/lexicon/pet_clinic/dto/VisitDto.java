package se.lexicon.pet_clinic.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VisitDto {
    private String id;
    private PetDto petDto;
    private LocalDate visitDate;
    private String description;
}

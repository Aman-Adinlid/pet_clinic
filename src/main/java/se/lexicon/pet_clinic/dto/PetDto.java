package se.lexicon.pet_clinic.dto;

import lombok.Data;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.PetType;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Data
public class PetDto {
    private String id;
    private String name;
    private LocalTime birthDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "pet_type_id")
    private PetType petType;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "owner_id")
    private Owner owner;
}

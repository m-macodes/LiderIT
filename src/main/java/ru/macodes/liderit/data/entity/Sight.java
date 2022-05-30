package ru.macodes.liderit.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.macodes.liderit.data.dto.SightDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    private String name;

    @JsonFormat(pattern = "yyyy.MM.dd")
    @NotNull
    private LocalDate dateConstruction;

    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    private SightType type;

    @ManyToOne
    private City city;

    public static Sight getSightFromDTO(SightDTO sightDTO, City city) {
        return Sight.builder()
                .name(sightDTO.getName())
                .dateConstruction(sightDTO.getDateConstruction())
                .description(sightDTO.getDescription())
                .type(sightDTO.getType())
                .city(city)
                .build();
    }
}

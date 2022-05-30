package ru.macodes.liderit.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.macodes.liderit.data.dto.CityDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String cityName;

    private int population;

    private boolean subwayAvailability;

    @NotNull
    private String country;

    public static City getCityFromDTO(CityDTO cityDTO) {
        return City.builder()
                .cityName(cityDTO.getCityName())
                .population(cityDTO.getPopulation())
                .subwayAvailability(cityDTO.isSubwayAvailability())
                .country(cityDTO.getCountry())
                .build();
    }
}

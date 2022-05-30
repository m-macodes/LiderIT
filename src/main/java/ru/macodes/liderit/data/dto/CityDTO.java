package ru.macodes.liderit.data.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CityDTO {

    @NotBlank
    @NotEmpty
    String cityName;

    @Min(0)
    int population;

    boolean subwayAvailability;

    @NotBlank
    @NotEmpty
    String country;
}

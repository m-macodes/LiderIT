package ru.macodes.liderit.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ru.macodes.liderit.data.entity.SightType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class SightDTO {
    @NotBlank
    @NotEmpty
    private String name;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate dateConstruction;

    @NotBlank
    @NotEmpty
    private String description;

    private SightType type;

    @NotBlank
    @NotEmpty
    private String city;
}

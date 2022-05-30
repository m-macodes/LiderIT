package ru.macodes.liderit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.macodes.liderit.data.dto.CityDTO;
import ru.macodes.liderit.data.entity.City;
import ru.macodes.liderit.service.CityService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping("/add")
    public ResponseEntity<?> addCity(@Valid @RequestBody CityDTO cityDTO) {
        cityService.addCity(cityDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editCity(@Valid @RequestBody CityDTO editCityDTO) {
        cityService.editCity(editCityDTO);
        return ResponseEntity.ok().build();
    }
}

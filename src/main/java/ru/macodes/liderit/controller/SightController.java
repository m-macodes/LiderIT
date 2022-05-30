package ru.macodes.liderit.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.macodes.liderit.data.dto.SightDTO;
import ru.macodes.liderit.data.entity.SightType;
import ru.macodes.liderit.service.SightService;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/sight")
@RequiredArgsConstructor
public class SightController {
    private final SightService sightService;

    @PostMapping("/add")
    public ResponseEntity<?> addSight(@Valid @RequestBody SightDTO sightDTO) {
        sightService.addSight(sightDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getSight(@RequestParam(required = false) boolean sort,
                                      @RequestParam(required = false) SightType type) {
        return ResponseEntity.ok(sightService.getSights(sort, type));
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> getSightInCity(@PathVariable("city") String city) {
        return ResponseEntity.ok(sightService.getSights(city));
    }

    @PutMapping("/{sight}")
    public ResponseEntity<?> putSight(@PathVariable("sight") String sight,
                                      @RequestBody String description) {
        sightService.changeDescription(sight, description);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{sight}")
    public ResponseEntity<?> deleteSight(@PathVariable("sight") String sight) {
        sightService.deleteSight(sight);
        return ResponseEntity.ok().build();
    }
}

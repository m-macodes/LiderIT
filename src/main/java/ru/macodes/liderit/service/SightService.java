package ru.macodes.liderit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.macodes.liderit.data.dto.SightDTO;
import ru.macodes.liderit.data.entity.City;
import ru.macodes.liderit.data.entity.Sight;
import ru.macodes.liderit.data.entity.SightType;
import ru.macodes.liderit.data.repository.CityRepository;
import ru.macodes.liderit.data.repository.SightRepository;
import ru.macodes.liderit.utils.exception.CityException;
import ru.macodes.liderit.utils.exception.SightException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SightService {
    private final SightRepository sightRepository;
    private final CityRepository cityRepository;

    public void addSight(SightDTO sightDTO) throws SightException, CityException {
        if (sightRepository.findSightByName(sightDTO.getName()).isPresent()) {
            throw new SightException("Достопремечательность " + sightDTO.getName() + " существует");
        }
        Optional<City> city = cityRepository.findByCityName(sightDTO.getCity());
        if (city.isPresent()) {
            sightRepository.save(Sight.getSightFromDTO(sightDTO, city.get()));
        } else {
            throw new CityException("Города " + sightDTO.getCity() + " не существует");
        }
    }

    public List<Sight> getSights(boolean sort, SightType type) {
        List<Sight> sights = new ArrayList<>();
        if (sort && type != null) {
            sights = sightRepository.findSightsByTypeOrderByName(type);
        } else if (sort) {
            sights = sightRepository.findAllByOrderByName();
        } else if(type != null) {
            sights = sightRepository.findSightsByType(type);
        } else {
            sightRepository.findAll().forEach(sights::add);
        }
        return sights;
    }

    public List<Sight> getSights(String city) {
        List<Sight> sights = new ArrayList<>();
        sightRepository.findSightsByCity_CityName(city).forEach(sights::add);
        return sights;
    }

    public void changeDescription(String sightName, String description) throws SightException{
        Optional<Sight> sight = sightRepository.findSightByName(sightName);
        if (sight.isPresent()) {
            sight.get().setDescription(description);
            sightRepository.save(sight.get());
        } else {
            throw new SightException( sightName + " не существует");
        }
    }

    public void deleteSight(String sightName) throws SightException{
        Optional<Sight> sight = sightRepository.findSightByName(sightName);
        if (sight.isPresent()) {
            sightRepository.delete(sight.get());
        } else {
            throw new SightException( sightName + " не существует");
        }
    }
}

package ru.macodes.liderit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.macodes.liderit.data.dto.CityDTO;
import ru.macodes.liderit.data.entity.City;
import ru.macodes.liderit.data.repository.CityRepository;
import ru.macodes.liderit.utils.exception.CityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public void addCity(CityDTO cityDTO) throws CityException {
        if (cityRepository.findByCityNameAndCountry(cityDTO.getCityName(), cityDTO.getCountry()).isPresent()) {
            throw new CityException("Город " + cityDTO.getCityName() + " в стране " + cityDTO.getCountry() + " существует");
        }
        Optional<City> city = cityRepository.findByCityName(cityDTO.getCityName());
        if (!city.isPresent()) {
            cityRepository.save(City.getCityFromDTO(cityDTO));
        }
    }

    public void editCity(CityDTO editCityDTO) throws CityException {
        Optional<City> city = cityRepository.findByCityNameAndCountry(editCityDTO.getCityName(), editCityDTO.getCountry());
        if (city.isPresent()) {
            city.get().setSubwayAvailability(editCityDTO.isSubwayAvailability());
            city.get().setPopulation(editCityDTO.getPopulation());
            cityRepository.save(city.get());
        } else {
            throw new CityException("Города " + editCityDTO.getCityName() + " в стране " + editCityDTO.getCountry() + " не существует");
        }
    }
}

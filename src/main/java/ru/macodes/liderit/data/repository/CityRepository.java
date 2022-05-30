package ru.macodes.liderit.data.repository;

import org.springframework.data.repository.CrudRepository;
import ru.macodes.liderit.data.entity.City;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Integer> {
    Optional<City> findByCityNameAndCountry(String city, String country);
    Optional<City> findByCityName(String city);
}

package ru.macodes.liderit.data.repository;

import org.springframework.data.repository.CrudRepository;
import ru.macodes.liderit.data.entity.Sight;
import ru.macodes.liderit.data.entity.SightType;

import java.util.List;
import java.util.Optional;

public interface SightRepository extends CrudRepository<Sight, Integer> {
    Iterable<Sight> findSightsByCity_CityName(String City);

    List<Sight> findSightsByTypeOrderByName(SightType type);
    List<Sight> findAllByOrderByName();
    List<Sight> findSightsByType(SightType type);

    Optional<Sight> findSightByName(String sightName);
}

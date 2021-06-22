package io.github.demony.forestparktextgame.service;

import io.github.demony.forestparktextgame.domain.Plant;

import java.sql.SQLException;
import java.util.List;

public interface PlantService {
    List<Plant> getAvailablePlants() throws SQLException;
    Boolean addNewPlant();
    Boolean removePlant();
}

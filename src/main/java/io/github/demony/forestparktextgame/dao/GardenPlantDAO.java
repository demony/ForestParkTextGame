package io.github.demony.forestparktextgame.dao;

import io.github.demony.forestparktextgame.domain.GardenPlant;

import java.sql.SQLException;

public interface GardenPlantDAO extends CrudDAO<GardenPlant> {
    Long GetAmountOfPlants() throws SQLException;
}

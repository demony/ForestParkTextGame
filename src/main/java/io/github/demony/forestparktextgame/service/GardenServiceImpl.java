package io.github.demony.forestparktextgame.service;

import io.github.demony.forestparktextgame.dao.GardenPlantDAO;
import io.github.demony.forestparktextgame.dao.GardenPlantDAOImpl;
import io.github.demony.forestparktextgame.dao.PlantDAO;
import io.github.demony.forestparktextgame.dao.PlantDAOImpl;
import io.github.demony.forestparktextgame.domain.GardenPlant;
import io.github.demony.forestparktextgame.domain.Plant;

import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class GardenServiceImpl implements GardenService{
    @Override
    public Boolean killPlant(Long plantId) {
        return null;
    }

    @Override
    public Boolean artWorkWithPlant(Long plantId) {
        return null;
    }

    @Override
    public Boolean plantThePlant(Long plantId) throws SQLException {
        PlantDAO plantDAO = new PlantDAOImpl();
        Plant plant = plantDAO.get(plantId);

        GardenPlant gardenPlant = new GardenPlant(
                null,
                plant,
                "",
                null,
                null,
                null,
                false);

        GardenPlantDAO gardenPlantDAO = new GardenPlantDAOImpl();
        GardenPlant gardenPlantCreated = gardenPlantDAO.create(gardenPlant);
        return true;
    }

    @Override
    public Boolean plantRandomPlant() {
        return null;
    }

    @Override
    public Long getAllPlantsCount() throws SQLException {
        GardenPlantDAO gardenPlantDAO = new GardenPlantDAOImpl();
        Long cnt = gardenPlantDAO.GetAmountOfPlants();
        return cnt;
    }

    @Override
    public Long getThePlantCount(Plant plant) {
        return null;
    }
}

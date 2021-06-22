package io.github.demony.forestparktextgame.service;

import io.github.demony.forestparktextgame.dao.PlantDAOImpl;
import io.github.demony.forestparktextgame.domain.Plant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantServiceImpl implements PlantService{

    @Override
    public List<Plant> getAvailablePlants() throws SQLException {
        PlantDAOImpl plantDAO = new PlantDAOImpl();
        List<Plant> plants = plantDAO.getAll();
        return plants;
    }

    @Override
    public Boolean addNewPlant() {
        return null;
    }

    @Override
    public Boolean removePlant() {
        return null;
    }
}

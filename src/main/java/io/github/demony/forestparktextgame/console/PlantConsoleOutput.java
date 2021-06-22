package io.github.demony.forestparktextgame.console;

import io.github.demony.forestparktextgame.domain.Plant;
import io.github.demony.forestparktextgame.service.PlantService;
import io.github.demony.forestparktextgame.service.PlantServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantConsoleOutput {
    public void outputAllAvailablePlants() throws SQLException {
        PlantServiceImpl plantService = new PlantServiceImpl();
        List<Plant> availablePlants = plantService.getAvailablePlants();
        for (Plant plant : availablePlants) {
            System.out.println("PlantID = " + plant.getId()
                    + " " + plant.getName()
                    + " " + plant.getDescription());
        }
    }
}

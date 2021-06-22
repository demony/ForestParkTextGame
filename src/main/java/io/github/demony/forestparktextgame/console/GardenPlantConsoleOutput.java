package io.github.demony.forestparktextgame.console;

import io.github.demony.forestparktextgame.service.GardenService;
import io.github.demony.forestparktextgame.service.GardenServiceImpl;

import java.sql.SQLException;

public class GardenPlantConsoleOutput {
    public void showAvailableCommands(){
        System.out.println("Hello dear forester. Be careful with your forest.");
        System.out.println("Available commands:");
        System.out.println(" 10 - Show available plants for planting.");
        System.out.println(" 20 - Plant a plant.");
        System.out.println(" 30 - Art work with plant.");
        System.out.println(" 40 - Kill plant.");
        System.out.println(" 50 - Show park statistics.");
        System.out.println(" help - show this help screen");
        System.out.println(" 0  - Exit.");
    }
    public void showStatistics() throws SQLException {
        GardenService gardenService = new GardenServiceImpl();
        Long allPlantsCounter = gardenService.getAllPlantsCount();
        System.out.println("Total plants in the park = " + allPlantsCounter);
    }

    public void plantThePlant(String strPlantId) throws SQLException {
        System.out.println("Trying plant the plant by id = " +  strPlantId);
        Long plantId = Long.parseLong(strPlantId);
        GardenService gardenService = new GardenServiceImpl();
        Boolean result = gardenService.plantThePlant(plantId);
        System.out.println("Plant result = " + result);
    }
}

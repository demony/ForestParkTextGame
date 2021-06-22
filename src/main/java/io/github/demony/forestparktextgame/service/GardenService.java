package io.github.demony.forestparktextgame.service;

import io.github.demony.forestparktextgame.domain.Plant;

import java.sql.SQLException;

public interface GardenService {
    Boolean killPlant(Long plantId);
    Boolean artWorkWithPlant(Long plantId);
    Boolean plantThePlant(Long plantId) throws SQLException;
    Boolean plantRandomPlant();
    Long getAllPlantsCount() throws SQLException;
    Long getThePlantCount(Plant plant);
}

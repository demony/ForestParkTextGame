package io.github.demony.forestparktextgame.dao;

import io.github.demony.forestparktextgame.domain.GardenPlant;
import io.github.demony.forestparktextgame.domain.Plant;

import java.sql.*;
import java.util.List;

public class GardenPlantDAOImpl implements GardenPlantDAO{

    @Override
    public GardenPlant get(Long id) throws SQLException {
        ConnectionDAO connectionDAO = ConnectionDAO.instance();
        Plant plant = null;
        GardenPlant gardenPlant = null;
        try (final Connection conn = connectionDAO.createConnection();
             final Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             final ResultSet rs = statement.executeQuery("select * from GARDEN_PLANTS where id = " + id)) {

            while (rs.next()) {
                plant = new Plant(rs.getLong("id"), null, null);
                gardenPlant = new GardenPlant(
                        rs.getLong("id"),
                        plant,
                        rs.getString("description"),
                        null,
                        null,
                        null,
                        rs.getBoolean("removed")
                );
            }
        }
        return  gardenPlant;

    }

    @Override
    public List<GardenPlant> getAll() throws SQLException {
        return null;
    }

    @Override
    public GardenPlant update(Long id) {
        return null;
    }

    @Override
    public GardenPlant create(GardenPlant gardenPlant) throws SQLException {

        ConnectionDAO connectionDAO = ConnectionDAO.instance();
        String sql = "INSERT INTO GARDEN_PLANTS "
        + " ( PLANT_ID, HEALTH, ART_PROC_DATE, PLANTED_DATE, REMOVED_DATE, REMOVED, DESCRIPTION ) "
        + " VALUES ( ?, 100, NULL, NOW(), NULL, FALSE, ?);";
        final Long plantId = gardenPlant.getPlant().getId();
        ResultSet rs = null;
        Long createdGardenPlantId = null;

        try (Connection conn = connectionDAO.createConnection();){

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setLong(1, plantId);
                preparedStatement.setString(2, "New plant");

                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected == 1 ) {
                    rs = preparedStatement.getGeneratedKeys();
                    if (rs.next()) {
                        createdGardenPlantId = rs.getLong(1);
                    }
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        GardenPlant createdGardenPlant = this.get(createdGardenPlantId);
        return  createdGardenPlant;
    }

    @Override
    public GardenPlant delete(Long id) {
        return null;
    }

    @Override
    public Long GetAmountOfPlants() throws SQLException {
        ConnectionDAO connectionDAO = ConnectionDAO.instance();
        Long result = 0L;
        try (final Connection conn = connectionDAO.createConnection();
             final Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             final ResultSet rs = statement.executeQuery("select count(*) as cnt from GARDEN_PLANTS")) {

            while (rs.next()) {
                result = rs.getLong("cnt");
            }
        }
        return  result;
    }
}

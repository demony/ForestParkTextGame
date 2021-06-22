package io.github.demony.forestparktextgame.dao;

import io.github.demony.forestparktextgame.domain.Plant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PlantDAOImpl implements PlantDAO{
    private static ConnectionDAO connectionDAO;

    @Override
    public Plant get(Long id) throws SQLException {
        connectionDAO = ConnectionDAO.instance();
        Plant result = null;
        try (final Connection conn = connectionDAO.createConnection();
             final Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             final ResultSet rs = statement.executeQuery("select * from Plants where id = " + id)) {

            while (rs.next()) {
                result = new Plant(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description")
                        );
            }
        }
        return result;
    }

    @Override
    public List<Plant> getAll() throws SQLException {

        List<Plant> result = new ArrayList<>();

        connectionDAO = ConnectionDAO.instance();
        try (final Connection conn = connectionDAO.createConnection();
             final Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             final ResultSet rs = statement.executeQuery("select * from Plants")) {

            while (rs.next()) {
                result.add(new Plant(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description")
                        )
                );
            }
        }
        return result;
    }

    @Override
    public Plant update(Long id) {
        return null;
    }

    @Override
    public Plant create(Plant element) {
        return null;
    }

    @Override
    public Plant delete(Long id) {
        return null;
    }
}

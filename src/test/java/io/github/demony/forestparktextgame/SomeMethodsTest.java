package io.github.demony.forestparktextgame;

import io.github.demony.forestparktextgame.domain.Plant;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SomeMethodsTest {
    private static ConnectionSource connectionSource;

    @BeforeClass
    public static void initConnectionSource() {
        connectionSource = ConnectionSource.instance();
    }

    @Test
    public void getAllPlantsTest() throws SQLException {
        try (final Connection conn = connectionSource.createConnection();
             final Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             final ResultSet rs = statement.executeQuery("select top 2 * from Plants")) {

            Set<Plant> expected = new LinkedHashSet<>();
            expected.add(new Plant(0L, "Birch" , "Curly"));
            expected.add(new Plant(1L, "Oak" , "Strong"));

//            [Plant{id=0, name='Birch', description='Curly'},
//            Plant{id=1, name='Oak', description='Strong'},
//            Plant{id=2, name='Shrub', description='Bushy'},
//            Plant{id=3, name='Weed', description='Green'}]


            Set<Plant> actual = new LinkedHashSet<>();
            while (rs.next()) {
                actual.add(new Plant(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description")
                        )
                );
            }

            assertEquals(expected, actual);

        }
    }

}

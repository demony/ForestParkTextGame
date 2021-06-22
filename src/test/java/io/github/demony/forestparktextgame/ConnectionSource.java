package io.github.demony.forestparktextgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConnectionSource {
    private static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private static final String DB_URL = "jdbc:hsqldb:mem:myDB";

    private static final String USER = "sa";
    private static final String PASS = "sa";

    private static final  ConnectionSource instance = new ConnectionSource();

    public static  ConnectionSource instance() { return instance; }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private ConnectionSource() {

        try {
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                try (Statement statement = connection.createStatement()) {
                    statement.execute(getSQL("init-ddl.sql"));
                }
                try (Statement statement = connection.createStatement()) {
                    statement.execute(getSQL("init-dml.sql"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String getSQL(final  String resourceName) {
        return new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                ConnectionSource.class.getClassLoader().getResourceAsStream(resourceName)
                        )
                )
        ).lines().collect(Collectors.joining("\n"));
    }
}

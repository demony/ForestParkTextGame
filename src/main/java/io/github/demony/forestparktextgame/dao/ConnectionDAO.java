package io.github.demony.forestparktextgame.dao;

import com.sun.source.tree.ReturnTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConnectionDAO {

    private static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private  static final String DB_FOLDER = "DB\\ForestParkDB";
    private static final String DB_URL = "jdbc:hsqldb:file:" + DB_FOLDER;

    private static final String USER = "sa";
    private static final String PASS = "sa";

    private static final ConnectionDAO instance = new ConnectionDAO();

    public static ConnectionDAO instance() { return instance; }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private ConnectionDAO() {

        try {
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
            Path path = Path.of(DB_FOLDER + ".script");
            if (Files.exists(path)) {
                // System.out.println("Database already exists");
            } else {
                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(getSQL("init-ddl.sql"));
                    }
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(getSQL("init-dml.sql"));
                    }
                    System.out.println("Database created");
               }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public String CreateTablesForNewApp() {
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

        return "Database fulfillment completed.";
    }

    private static String getSQL(final  String resourceName) {
        return new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                ConnectionDAO.class.getClassLoader().getResourceAsStream(resourceName)
                        )
                )
        ).lines().collect(Collectors.joining("\n"));
    }
}

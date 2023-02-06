package com.studenti.uninsubria.emotionalsongs.ServerES.Connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

/**
 * @author luqmanasghar
 */
public class ConnectionFactory {

    // <editor-fold desc="Attributi">
    private final ServerInformation serverInformation;

    // </editor-fold>

    // <editor-fold desc="Costruttore">
    public ConnectionFactory(String username, String password) throws IOException {
        serverInformation = new ServerInformation();
        serverInformation.setUsername(username);
        serverInformation.setPassword(password);
    }

    public ConnectionFactory() throws IOException {
        serverInformation = new ServerInformation();
    }

    // </editor-fold>

    // <editor-fold desc="Getters">

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(serverInformation.getConnectionString(),
                    serverInformation.getUsername(),
                    serverInformation.getPassword());
    }

    /**
     *
     * @param connection
     * @return
     * @throws SQLException
     */
    public Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public Statement getStatement() throws SQLException {
        Connection connection = getConnection();
        return connection.createStatement();
    }

    // </editor-fold>

}

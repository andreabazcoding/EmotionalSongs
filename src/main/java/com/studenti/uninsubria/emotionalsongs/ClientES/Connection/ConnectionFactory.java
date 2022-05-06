package com.studenti.uninsubria.emotionalsongs.ClientES.Connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author luqmanasghar
 */
public class ConnectionFactory {

    private final ServerInformation serverInformation;

    public ConnectionFactory(String username, String password) throws IOException {
        serverInformation = new ServerInformation();
        serverInformation.setUsername(username);
        serverInformation.setPassword(password);
    }

    public ConnectionFactory() throws IOException {
        serverInformation = new ServerInformation();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(serverInformation.getConnectionString(),
                    serverInformation.getUsername(),
                    serverInformation.getPassword());
    }

    public Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public Statement getStatement() throws SQLException {
        Connection connection = getConnection();
        return connection.createStatement();
    }

}

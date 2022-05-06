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
    private Connection connection;
    private Statement statement;

    public ConnectionFactory(String username, String password) throws IOException {
        serverInformation = new ServerInformation();
        serverInformation.setUsername(username);
        serverInformation.setPassword(password);
    }

    public ConnectionFactory() throws IOException {
        serverInformation = new ServerInformation();
    }

    public Connection getConnection() throws SQLException {
        try {
            if(connection == null){
                connection = DriverManager.getConnection(serverInformation.getConnectionString(),
                        serverInformation.getUsername(),
                        serverInformation.getPassword());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

        return connection;
    }

    public void closeConnection() throws SQLException {
        if(connection != null) {
            connection.close();
            connection = null;
        }
    }

    public Statement getStatement() throws SQLException {
        if (statement == null) {
            Connection connection = getConnection();
            statement = connection.createStatement();
        }
        return statement;
    }

}

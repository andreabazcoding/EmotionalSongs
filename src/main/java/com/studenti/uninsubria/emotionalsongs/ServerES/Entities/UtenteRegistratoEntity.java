package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;

import java.io.IOException;
import java.sql.*;

/**
 * @author luqmanasghar
 */
public class UtenteRegistratoEntity {
    private Connection connection;
    private Statement statement;

    public UtenteRegistratoEntity(){ }

    public void Create(UtenteRegistratoModel utenteRegistrato) throws SQLException, IOException {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("INSERT INTO \"EmotionalSongs\".\"UtenteRegistrato\"(");
            sb.append("\"Nome\", \"Cognome\",\"CodiceFiscale\", \"Indirizzo\", \"Email\", \"Username\", \"Password\")");
            sb.append("VALUES (?, ?, ?, ?, ?, ?, ?);");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, utenteRegistrato.getNome());
            preparedStatement.setString(2, utenteRegistrato.getCognome());
            preparedStatement.setString(3, utenteRegistrato.getCodiceFiscale());
            preparedStatement.setString(4, utenteRegistrato.getIndirizzo());
            preparedStatement.setString(5, utenteRegistrato.getEmail());
            preparedStatement.setString(6, utenteRegistrato.getUsername());
            preparedStatement.setString(7, utenteRegistrato.getPassword());

            int res = preparedStatement.executeUpdate();

            connection.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        finally {
            if(connection != null && !connection.isClosed())
                connection.close();
        }
    }

    public int AuthenticateUser(String username, String password) throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        int userId = 0;

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"UtenteRegistratoID\" ");
            sb.append("FROM \"EmotionalSongs\".\"UtenteRegistrato\" ");
            sb.append("WHERE \"Username\" = ? ");
            sb.append("AND \"Password\" = ? ");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                userId = resultSet.getInt(1);
            }

            connection.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        finally {
            if(connection != null && !connection.isClosed())
                connection.close();
        }

        return userId;
    }
}

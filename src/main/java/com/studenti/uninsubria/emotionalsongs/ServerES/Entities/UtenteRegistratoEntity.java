package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
        Statement statement = null;

        try {
            connection = connectionFactory.getConnection();
            statement = connectionFactory.getStatement(connection);

            sb.append("INSERT INTO \"EmotionalSongs\".\"UtenteRegistrato\"(");
            sb.append("\"Nome\", \"Cognome\", \"Indirizzo\", \"Email\", \"Username\", \"Password\")");
            sb.append("VALUES (?, ?, ?, ?, ?, ?);");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, utenteRegistrato.getNome());
            preparedStatement.setString(2, utenteRegistrato.getCognome());
            preparedStatement.setString(3, utenteRegistrato.getIndirizzo());
            preparedStatement.setString(4, utenteRegistrato.getEmail());
            preparedStatement.setString(5, utenteRegistrato.getUsername());
            preparedStatement.setString(6, utenteRegistrato.getPassword());

            int res = preparedStatement.executeUpdate();

            connection.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        finally {
            if(!connection.isClosed())
                connection.close();
        }
    }

}

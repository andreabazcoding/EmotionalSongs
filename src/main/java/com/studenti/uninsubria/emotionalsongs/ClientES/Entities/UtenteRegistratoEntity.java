package com.studenti.uninsubria.emotionalsongs.ClientES.Entities;

import com.studenti.uninsubria.emotionalsongs.ClientES.Connection.ConnectionFactory;
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
        try {
            connection = connectionFactory.getConnection();
            statement = connectionFactory.getStatement();

            sb.append("INSERT INTO UtenteRegistrato(Nome, Cognome, Indirizzo, Email, Username, Password) ");
            sb.append("VALUES (?, ?, ?, ?, ?, ?);");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, utenteRegistrato.getNome());
            preparedStatement.setString(2, utenteRegistrato.getCognome());
            preparedStatement.setString(3, utenteRegistrato.getIndirizzo());
            preparedStatement.setString(4, utenteRegistrato.getEmail());
            preparedStatement.setString(5, utenteRegistrato.getUsername());
            preparedStatement.setString(6, utenteRegistrato.getPassword());

            int res = preparedStatement.executeUpdate(sb.toString());

            connection.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

}

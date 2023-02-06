package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;

import java.io.IOException;
import java.sql.*;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

/**
 * La classe contiene i metodi per eseguire operazioni sulla tabella UtenteRegistrato nel database.
 * @author luqmanasghar
 */
public class UtenteRegistratoEntity {

    // <editor-fold desc="Attributi">
    private Connection connection;
    private Statement statement;

    // </editor-fold>

    // <editor-fold desc="Costruttore">
    public UtenteRegistratoEntity(){ }
    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Effettua la connessione al database ed esegue la query di inserimento di un utente nel database.
     * @param utenteRegistrato
     * @throws SQLException
     * @throws IOException
     */
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

    /**
     * autenticazione dell'utente registrato
     * @param username
     * @param password
     * @return
     * @throws SQLException
     * @throws IOException
     */
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

    // </editor-fold>

}

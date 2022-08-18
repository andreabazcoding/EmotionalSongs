package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.PlaylistModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;

import java.io.IOException;
import java.sql.*;

/**
 * La classe contiene i metodi per eseguire operazioni sulla tabella Playlist nel database
 * @author Luqman Asghar
 * @author Cristian Zuffellato
 */

public class PlaylistEntity {

    private Connection connection;
    private Statement statement;

    /**
     * Costruttore vuoto
     */
    public PlaylistEntity() {

    }

    /**
     * Effettua la connessione al database ed esegue la query di inserimento di una nuova playlist
     * @param playlistModel dati playlist
     * @param utenteRegistratoModel dati utente creatore della playlist
     * @throws IOException
     * @throws SQLException
     */
    public void Create(PlaylistModel playlistModel, UtenteRegistratoModel utenteRegistratoModel) throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();


        try{
            connection = connectionFactory.getConnection();
            statement = connectionFactory.getStatement(connection);

            sb.append("INSERT INTO \"EmotionalSongs\".\"Playlist\"(");
            sb.append("\"NomePlaylist\", \"UtenteRegistratoID\")");
            sb.append("VALUES (?, ?);");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            preparedStatement.setString(1,playlistModel.getNomePlaylist());
            preparedStatement.setInt(2,utenteRegistratoModel.getUtenteRegistratoID());

            int res = preparedStatement.executeUpdate();

            connection.close();

        }catch(Exception ex){

            ex.printStackTrace();
            throw ex;

        }finally {

            if(!connection.isClosed())
                connection.close();

        }

    }

    /**
     * Effettua la connessione al database ed esegue la query per estrarre tutte le playlist
     * @return resultset
     * @throws IOException
     * @throws SQLException
     */
    public static ResultSet allPlaylists() throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        Statement statement = null;

        try{
            connection = connectionFactory.getConnection();
            statement = connectionFactory.getStatement(connection);

            sb.append("SELECT \"PlaylistID\", \"NomePlaylist\", \"Username\"");
            sb.append("FROM \"EmotionalSongs\".\"Playlist\"");
            sb.append("INNER JOIN \"EmotionalSongs\".\"UtenteRegistrato\"");
            sb.append("ON \"Playlist\".\"UtenteRegistratoID\" = \"UtenteRegistrato\".\"UtenteRegistratoID\";");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            connection.close();

            return  resultSet;

        }catch(Exception ex){

            ex.printStackTrace();
            throw ex;

        }finally {

            if(!connection.isClosed())
                connection.close();

        }
    }

}

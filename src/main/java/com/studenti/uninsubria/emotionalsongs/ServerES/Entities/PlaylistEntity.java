package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CrossPlaylistCanzoniModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.PlaylistModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;
import java.io.IOException;
import java.sql.*;


//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

/**
 * La classe contiene i metodi per eseguire operazioni sulla tabella Playlist nel database.
 * @author Luqman Asghar
 * @author Cristian Zuffellato
 */

public class PlaylistEntity {

    // <editor-fold desc="Attributi">
    private Connection connection;
    private Statement statement;

    // </editor-fold>

    // <editor-fold desc="Costruttore">
    /**
     * Costruttore vuoto
     */
    public PlaylistEntity() {

    }

    // </editor-fold>

    // <editor-fold desc="Methods">

    /**
     * Effettua la connessione al database ed esegue la query di inserimento di una nuova playlist
     * @param playlistModel dati playlist
     * @param utenteRegistratoModel dati utente creatore della playlist
     * @throws IOException
     * @throws SQLException
     */
    public int Create(PlaylistModel playlistModel, UtenteRegistratoModel utenteRegistratoModel) throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        int createdPlaylistId = 0;

        try{
            connection = connectionFactory.getConnection();

            sb.append("INSERT INTO \"EmotionalSongs\".\"Playlist\"(");
            sb.append("\"NomePlaylist\", \"UtenteRegistratoID\")");
            sb.append("VALUES (?, ?);");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, playlistModel.getNomePlaylist());
            preparedStatement.setInt(2, utenteRegistratoModel.getUtenteRegistratoID());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            connection.close();

            while(resultSet.next())
                createdPlaylistId = resultSet.getInt(1);

        }catch(Exception ex){

            ex.printStackTrace();
            throw ex;

        }finally {

            if(connection != null && !connection.isClosed())
                connection.close();

        }

        return createdPlaylistId;
    }

    /**
     * Effettua la connessione al database ed esegue la query di inserimento di una corrispondenza canzone-playlist
     * @param crossPlaylistCanzoniModel
     * @throws IOException
     * @throws SQLException
     */
    public void CreateCrossPlaylist(CrossPlaylistCanzoniModel crossPlaylistCanzoniModel) throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try{
            connection = connectionFactory.getConnection();

            sb.append("INSERT INTO \"EmotionalSongs\".\"CrossPlaylistCanzoni\"(");
            sb.append("\"CanzoneID\", \"PlaylistID\")");
            sb.append("VALUES (?, ?);");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, crossPlaylistCanzoniModel.getCanzoneID());
            preparedStatement.setInt(2, crossPlaylistCanzoniModel.getPlaylistID());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            connection.close();

        }catch(Exception ex){

            ex.printStackTrace();
            throw ex;

        }finally {

            if(connection != null && !connection.isClosed())
                connection.close();

        }

    }

    /**
     * Estrae le informazioni della playlist desiderata
     * @return PlaylistModel
     * @throws IOException
     * @throws SQLException
     */
    public static PlaylistModel Read(int playlistId) throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;

        PlaylistModel playlistmodel = new PlaylistModel();

        try{
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"PlaylistID\", \"NomePlaylist\", \"UtenteRegistratoID\"");
            sb.append("FROM \"EmotionalSongs\".\"Playlist\"");
            sb.append("WHERE \"Playlist\".\"PlaylistID\" = ").append(playlistId);

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            connection.close();

            while(resultSet.next()){
                playlistmodel.setPlaylistID(resultSet.getInt(1));
                playlistmodel.setNomePlaylist(resultSet.getString(2));
                playlistmodel.setUtenteRegistratoID(resultSet.getInt(3));
            }

        }catch(Exception ex){

            ex.printStackTrace();
            throw ex;

        }finally {

            if(connection != null && !connection.isClosed())
                connection.close();

        }

        return playlistmodel;
    }


    /**
     * Effettua la connessione al database ed esegue la query per estrarre le canzoni presenti in una specifica playlist
     * @param playlistId
     * @return resultSet
     * @throws IOException
     * @throws SQLException
     */
    public static ResultSet getSongs(int playlistId) throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        Statement statement = null;

        try{
            connection = connectionFactory.getConnection();
            statement = connectionFactory.getStatement(connection);

            sb.append("SELECT \"Canzone\".\"CanzoneID\", \"Titolo\", \"Autore\", \"Anno\"");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\"");
            sb.append("INNER JOIN \"EmotionalSongs\".\"CrossPlaylistCanzoni\"");
            sb.append("ON \"Canzone\".\"CanzoneID\" = \"CrossPlaylistCanzoni\".\"CanzoneID\"");
            sb.append("WHERE \"CrossPlaylistCanzoni\".\"PlaylistID\" = ").append(playlistId);

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            connection.close();

            return  resultSet;

        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;

        }finally {
            if(connection != null && !connection.isClosed())
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

            if(connection != null && !connection.isClosed())
                connection.close();

        }
    }

    /**
     * Effettua la connessione al database ed esegue la query per
     * verificare se esiste già una playlist con il nome passato dall'utente.
     * @return boolean
     * @throws IOException
     * @throws SQLException
     */
    public static boolean checkPlaylistExists(String nomePlaylist, int utenteId) throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;

        try{
            connection = connectionFactory.getConnection();

            sb.append("SELECT * FROM \"EmotionalSongs\".\"Playlist\" ");
            sb.append("WHERE \"Playlist\".\"UtenteRegistratoID\" = ").append(utenteId);
            sb.append(" AND \"Playlist\".\"NomePlaylist\" = '").append(nomePlaylist).append("'");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            connection.close();

            return resultSet.next();

        }catch(Exception ex){

            ex.printStackTrace();
            throw ex;

        }finally {

            if(connection != null && !connection.isClosed())
                connection.close();

        }
    }

    // </editor-fold>
}

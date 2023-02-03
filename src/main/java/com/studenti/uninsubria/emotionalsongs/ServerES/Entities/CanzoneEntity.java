package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luqmanasghar
 */
public class CanzoneEntity {

    // <editor-fold desc="Methods">

    /**
     * Creazione di canzoneEntity a partire da Canzone Model
     * @param canzone
     * @throws SQLException
     * @throws IOException
     */
    public void Create(CanzoneModel canzone) throws SQLException, IOException {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("INSERT INTO \"EmotionalSongs\".\"Canzone\"(");
            sb.append("\"Titolo\", \"Autore\", \"Album\", \"Anno\", \"Durata\", \"Genere\")");
            sb.append("VALUES (?, ?, ?, ?, ?, ?);");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, canzone.getTitolo());
            preparedStatement.setString(2, canzone.getAutore());
            preparedStatement.setString(3, canzone.getAlbum());
            preparedStatement.setInt(4, canzone.getAnno());
            preparedStatement.setDouble(5, canzone.getDurata());
            preparedStatement.setString(6, canzone.getGenere());

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
     * Estrazione delle informazioni delle canzoni
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public ResultSet allSongs() throws SQLException, IOException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"CanzoneID\", \"Titolo\", \"Autore\", \"Album\", \"Anno\", \"Durata\", \"Genere\" ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\"");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            resultSet = preparedStatement.executeQuery();

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
        return resultSet;
    }

    /**
     * Estrazione delle informazioni delle canzoni filtrate per playlist
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public ResultSet allSongs(int playlistID, int utenteRegistratoID) throws SQLException, IOException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"Titolo\", \"Autore\", \"Album\", \"Anno\", \"Durata\", \"Genere\"");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" INNER JOIN \"EmotionalSongs\".\"CrossPlaylistCanzoni\"");
            sb.append("ON \"Canzone\".\"CanzoneID\" = \"CrossPlaylistCanzoni\".\"CanzoneID\"");
            sb.append("INNER JOIN \"EmotionalSongs\".\"Playlist\"");
            sb.append("ON \"Playlist\".\"PlaylistID\" = \"CrossPlaylistCanzoni\".\"PlaylistID\"");
            sb.append("WHERE \"Playlist\".\"PlaylistID\" =").append(playlistID);
            sb.append("AND \"Playlist\".\"UtenteRegistratoID\" =").append(utenteRegistratoID);

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            resultSet = preparedStatement.executeQuery();

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
        return resultSet;
    }

    public ResultSet getListByFilter(String titolo, String autore, int anno) throws IOException, SQLException {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"CanzoneID\", \"Titolo\", \"Autore\", \"Album\", \"Anno\", \"Durata\", \"Genere\" ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("WHERE ");
            if(!titolo.trim().isEmpty()){
                sb.append("\"Titolo\" like '%");
                sb.append(titolo.replaceAll("'", "''"));
                sb.append("%';");
            }else{
                sb.append("\"Autore\" like '%");
                sb.append(autore.replaceAll("'", "''"));
                sb.append("%'");
                if(anno > 0){
                    sb.append(" AND \"Anno\" =");
                    sb.append(anno);
                }
                sb.append(";");
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            resultSet = preparedStatement.executeQuery();

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet searchingByTitle(String titolo) throws IOException, SQLException {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"Titolo\", \"Autore\", \"Album\", \"Anno\", \"Durata\", \"Genere\" ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("WHERE \"Titolo\" like '%");
            sb.append(titolo);
            sb.append("%';");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            resultSet = preparedStatement.executeQuery();

            connection.close();

            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet searchingByAuthorAndYear(String autore, int anno) throws IOException, SQLException {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"Titolo\", \"Autore\", \"Album\", \"Anno\", \"Durata\", \"Genere\" ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("WHERE \"Autore\" like '%");
            sb.append(autore);
            sb.append("%';");
            sb.append("AND \"Anno\" =");
            sb.append(anno);

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            resultSet = preparedStatement.executeQuery();

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet distinctYear() throws IOException {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT DISTINCT \"Anno\"");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("ORDER BY \"Anno\" DESC ");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());

            resultSet = preparedStatement.executeQuery();

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;

    }

    public List<CanzoneModel> ExtractAllInfo() throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        CanzoneModel model = null;
        List<CanzoneModel> listCanzone = new ArrayList<>();

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT * ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\";");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                model = new CanzoneModel();
                model.setCanzoneID(resultSet.getInt(1));
                model.setTitolo(resultSet.getString(2));
                model.setAutore(resultSet.getString(3));
                model.setAlbum(resultSet.getString(4));
                model.setAnno(resultSet.getInt(5));
                model.setDurata(resultSet.getShort(6));
                model.setGenere(resultSet.getString(7));

                listCanzone.add(model);
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

        return listCanzone;
    }

    public List<CanzoneModel> ExtractTitleAndAuthor() throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        CanzoneModel model = null;
        List<CanzoneModel> listCanzone = new ArrayList<>();

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"Titolo\", \"Autore\" ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("ORDER BY \"Canzone\" . \"Titolo\" ASC;");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                model = new CanzoneModel();
                model.setTitolo(resultSet.getString(1));
                model.setAutore(resultSet.getString(2));

                listCanzone.add(model);
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

        return listCanzone;
    }

    public List<CanzoneModel> SearchingById(int canzoneID) throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        CanzoneModel model = null;
        List<CanzoneModel> listCanzone = new ArrayList<>();

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT * ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("WHERE \"CanzoneID\" = " + canzoneID + ";");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                model = new CanzoneModel();
                model.setCanzoneID(resultSet.getInt(1));
                model.setTitolo(resultSet.getString(2));
                model.setAutore(resultSet.getString(3));
                model.setAlbum(resultSet.getString(4));
                model.setAnno(resultSet.getInt(5));
                model.setDurata(resultSet.getShort(6));
                model.setGenere(resultSet.getString(7));

                listCanzone.add(model);
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

        return listCanzone;
    }

    public List<CanzoneModel> SearchingByAuthorAndYear(String autoreSubstr, int anno) throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        CanzoneModel model = null;
        List<CanzoneModel> listCanzone = new ArrayList<>();

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT * ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("WHERE \"Autore\" LIKE '%" + autoreSubstr + "%' AND \"Anno\" = " + anno + ";");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                model = new CanzoneModel();
                model.setCanzoneID(resultSet.getInt(1));
                model.setTitolo(resultSet.getString(2));
                model.setAutore(resultSet.getString(3));
                model.setAlbum(resultSet.getString(4));
                model.setAnno(resultSet.getInt(5));
                model.setDurata(resultSet.getShort(6));
                model.setGenere(resultSet.getString(7));

                listCanzone.add(model);
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

        return listCanzone;
    }

    /**/
    public ResultSet ExctractSummary(int[] arrCanzoneId) throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        CanzoneModel model = null;
        ResultSet resultSet = null;

        try {
            connection = connectionFactory.getConnection();

            /*La query viene esequita ad ogni iterazione per ogni canzone presente nella playlist*/
            for (int i = 0; i < arrCanzoneId.length; i++) {
                sb.append("SELECT \"EmozioneProvabile\".\"NomeEmozione\", COUNT(\"EmozioneProvabile\".\"NomeEmozione\"), AVG(\"Emozione\".\"IntensitaEmozione\") ");
                sb.append("FROM \"EmotionalSongs\".\"EmozioneProvabile\" ");
                sb.append("INNER JOIN \"EmotionalSongs\".\"Emozione\" USING(\"EmozioneProvabileID\") ");
                sb.append("WHERE \"Emozione\".\"CanzoneID\" = " + arrCanzoneId[i] + " ");
                sb.append("GROUP BY (\"EmozioneProvabile\".\"NomeEmozione\");");

                PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
                resultSet = preparedStatement.executeQuery();

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

        return resultSet;
    }

    // </editor-fold>

}
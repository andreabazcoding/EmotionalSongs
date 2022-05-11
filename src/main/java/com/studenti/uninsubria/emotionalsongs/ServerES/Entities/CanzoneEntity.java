package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.EmozioneProvabileModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.PlaylistModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luqmanasghar
 */
public class CanzoneEntity {

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
            preparedStatement.setInt(5, canzone.getDurata());
            preparedStatement.setString(6, canzone.getGenere());

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

    public List<CanzoneModel> SerchingByTitle(String titolo) throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        CanzoneModel model = null;
        List<CanzoneModel> listCanzone = new ArrayList<>();

        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"CanzoneID\", \"Titolo\", \"Autore\", \"Album\", \"Anno\", \"Durata\", \"Genere\" ");
            sb.append("FROM \"EmotionalSongs\".\"Canzone\" ");
            sb.append("WHERE \"Username\" like '%");
            sb.append(titolo);
            sb.append("%';");

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
            if(!connection.isClosed())
                connection.close();
        }

        return listCanzone;
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
            if(!connection.isClosed())
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
            if(!connection.isClosed())
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
            if(!connection.isClosed())
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
            if(!connection.isClosed())
                connection.close();
        }

        return listCanzone;
    }

    /**/
    public List<CanzoneModel> ExctractSummary(int[] arrCanzoneId) throws SQLException, IOException  {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        CanzoneModel model = null;
        List<CanzoneModel> listCanzone = new ArrayList<>();

        try {
            connection = connectionFactory.getConnection();

            /*La query viene esequita ad ogni iterazione per ogni canzone presente nella playlist*/
            for (int i = 0; i < arrCanzoneId.length; i++) {
                sb.append("SELECT \"EmozioneProvabile\".\"NomeEmozione\", COUNT(\"EmozioneProvabile\".\"NomeEmozione\"), AVG(\"Emozione\".\"IntensitaEmozione\") ");
                sb.append("FROM \"EmotionalSongs\".\"EmozioneProvabile\" ");
                sb.append("INNER JOIN \"EmotionalSongs\".\"Emozione\" USING(\"EmozioneProvabileID\") ");
                sb.append("INNER JOIN \"EmotionalSongs\".\"Canzone\" USING(\"CanzoneID\") ");
                sb.append("WHERE \"Canzone\".\"CanzoneID\" = " + arrCanzoneId[i] + " ");
                sb.append("GROUP BY (\"EmozioneProvabile\".\"NomeEmozione\");");

                PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    //?
                }
            }
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

        return listCanzone;
    }


}
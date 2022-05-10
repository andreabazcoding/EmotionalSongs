package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.PlaylistModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.UtenteRegistratoModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PlaylistEntity {

    private Connection connection;
    private Statement statement;

    public PlaylistEntity() {

    }

    public void Create(PlaylistModel playlistModel, UtenteRegistratoModel utenteRegistratoModel) throws IOException, SQLException {

        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        Statement statement = null;

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

}

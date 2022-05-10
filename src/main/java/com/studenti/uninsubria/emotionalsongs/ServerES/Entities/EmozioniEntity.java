package com.studenti.uninsubria.emotionalsongs.ServerES.Entities;

import com.studenti.uninsubria.emotionalsongs.ClientES.Model.CanzoneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.EmozioneModel;
import com.studenti.uninsubria.emotionalsongs.ClientES.Model.EmozioneProvabileModel;
import com.studenti.uninsubria.emotionalsongs.ServerES.Connection.ConnectionFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmozioniEntity {

    private Connection connection;
    private Statement statement;

    public EmozioniEntity() {
    }

    public List<EmozioneModel> FeltEmotions(CanzoneModel canzoneModel, EmozioneProvabileModel emozioneProvabileModel) throws IOException, SQLException {
        StringBuilder sb = new StringBuilder();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        EmozioneModel model = null;
        List<EmozioneModel> listEmozioni = new ArrayList<>();
        try {
            connection = connectionFactory.getConnection();

            sb.append("SELECT \"EmozioneID\", \"UtenteRegistratoID\", \"CanzoneID\", \"EmozioneProvabileID\", \"IntensitaEmozione\", \"AnnotazioneEmozione\"");
            sb.append("FROM \"EmotionalSongs\".\"Emozione\";");

            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                model.setEmozioneID(resultSet.getInt(1));
                model.setUtenteRegistratoID(resultSet.getInt(2));
                model.setCanzoneID(resultSet.getInt(3));
                model.setEmozioneProvabileID(resultSet.getInt(4));
                model.setIntensità(resultSet.getInt(5));
                model.setAnnotazioneEmozione(resultSet.getString(6));

                listEmozioni.add(model);

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
        return listEmozioni;
    }
}

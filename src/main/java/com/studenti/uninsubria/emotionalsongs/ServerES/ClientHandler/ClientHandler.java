package com.studenti.uninsubria.emotionalsongs.ServerES.ClientHandler;

import java.io.*;
import java.net.Socket;

/**
 * @author AndreaBasilico
 */

public class ClientHandler extends Thread {

    static int connectionId = 0;

    Socket connection = null;
    OutputStream out;
    PrintWriter sOUT;

    InputStreamReader in;
    BufferedReader sIN;

    InputStream inputStream;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ClientHandler(Socket sk) {
        this.connection = sk;
        connectionId++;
    }

    @Override
    public synchronized void run() {
        try {
            out = connection.getOutputStream();
            sOUT = new PrintWriter(out);

            in = new InputStreamReader(connection.getInputStream());
            sIN = new BufferedReader(in);

            inputStream = connection.getInputStream();
            ois = new ObjectInputStream(inputStream);
            oos = new ObjectOutputStream(out);

            System.out.println("Client collegato");
            while (!connection.isClosed()) {
                if (connection.equals(null)) {
                    try {
                        System.out.println("Client disconnesso: chiusura del socket");
                        connection.close();
                    } catch (IOException e) {
                        System.out.println("Eccezione gestita: " + e);
                    }
                    break;
                } else {
                    try {
                        /*
                        DO SOMETHING
                        GESTIONE DELLE QUERY
                        * */
                    } catch (Exception e) {
                        System.err.println("Connessione chiusa: " + e);
                        break;
                    }
                }
            }
            System.out.println("Thread terminato");
        } catch (IOException e) {
            System.out.println("ERRORE: Chiusura connessione" + connection.getInetAddress() + " porta " + connection.getPort());
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e2) {
                    System.err.println("Errore: " + e2);
                }
            }
            System.err.println(e);
        }
    }
}

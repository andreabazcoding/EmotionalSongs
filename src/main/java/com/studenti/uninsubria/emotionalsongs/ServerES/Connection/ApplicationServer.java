package com.studenti.uninsubria.emotionalsongs.ServerES.Connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author AndreaBasilico
 */

public class ApplicationServer {

    public ApplicationServer() {}

    ServerSocket sSocket;
    Socket connection = null;
    int clientPort;
    InetAddress IPClient;

    public synchronized void handle()
    {
        try {
            sSocket = new ServerSocket(4321);
        } catch (IOException ex) {
            System.err.println(ex);
            return;
        }
        while (true) {
            try {
                System.out.println("SERVER In attesa di connessione...");
                connection = sSocket.accept();
                IPClient = connection.getInetAddress();
                clientPort = connection.getPort();
                System.out.println("Connessione accettata da " + IPClient + " porta: " + clientPort);
                new ClientHandler(connection).start();
                System.out.println("Creato Thread (ClientHandler)");
            } catch (Exception e) {
                System.out.println("ERRORE: Chiusura connessione");
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (IOException e2) {
                        System.err.println("Eccezione: " + e2);
                    }
                }
                System.err.println("Eccezione: " + e);
            }
        }
    }
}

package com.studenti.uninsubria.emotionalsongs.ServerES.Connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

/**
 * @author luqmanasghar
 */
public class ServerInformation {

    // <editor-fold desc="Attributi">
    private String protocol;
    private String username;
    private String db;
    private String ipServer;
    private String Password;
    private int port;

    // </editor-fold>

    // <editor-fold desc="Costruttore">

    /**
     * Reads the properties from config and populates
     * the attributes
     */
    public ServerInformation() throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            setProtocol(prop.getProperty("PROTOCOL"));
            setIpServer(prop.getProperty("IP_SERVER"));
            setPort(Integer.parseInt(prop.getProperty("PORT")));
            setDb(prop.getProperty("DB"));
            setUsername(prop.getProperty("USER"));
            setPassword(prop.getProperty("PSW"));

            //System.out.print(toString());

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (inputStream != null)
                inputStream.close();
        }
    }

    // </editor-fold>

    // <editor-fold desc="Getters&Setters">

    /**
     * assegna  protocol
     * @param protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * assegna  username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * assegna db
     * @param db
     */
    private void setDb(String db) {
        this.db = db;
    }

    /**
     * assegna ip
     * @param ipServer
     */
    private void setIpServer(String ipServer) {
        this.ipServer = ipServer;
    }

    /**
     * assegna password
     * @param password
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * assegna port
     * @param port
     */
    private void setPort(int port) {
        this.port = port;
    }

    /**
     * legge protocol
     * @return
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * legge username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * legge db
     * @return
     */
    public String getDb() {
        return db;
    }

    /**
     * legge ip
     * @return
     */
    public String getIpServer() {
        return ipServer;
    }

    /**
     * legge password
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     * legge port
     * @return
     */
    public int getPort() {
        return port;
    }

    /**
     *
     * @return
     */
    public String getConnectionString(){
        return getProtocol() + getIpServer() + ":" + getPort() + "/" + getDb();
    }

    // </editor-fold>

    // <editor-fold desc="Methods">

    @Override
    public String toString() {
        return "ServerInformation{" +
                "protocol='" + protocol + '\'' +
                ", username='" + username + '\'' +
                ", db='" + db + '\'' +
                ", ipServer='" + ipServer + '\'' +
                ", Password='" + Password + '\'' +
                ", port=" + port +
                '}';
    }

    // </editor-fold>
}

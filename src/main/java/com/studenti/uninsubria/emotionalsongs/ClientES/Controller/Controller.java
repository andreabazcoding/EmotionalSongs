package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import com.studenti.uninsubria.emotionalsongs.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author luqmanasghar
 */

public abstract class Controller extends Application {

    // <editor-fold desc="Attributi">

    public static final String path = "/View/";
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int userId;

    private int entityId;

    // </editor-fold>

    // <editor-fold desc="Attributi FXML">

    @FXML
    protected StackPane contentArea;

    // </editor-fold>

    // <editor-fold desc="Getters&Setters">

    public StackPane getContentArea() {
        return contentArea;
    }

    public void setContentArea(StackPane contentArea) {
        this.contentArea = contentArea;
    }


    /**
     * Returns the current users Id
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the current userId
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns the entityId
     * @return
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Sets the entityId
     * @param entityId
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    // </editor-fold>

    // <editor-fold desc="Methods that change or load view">

    /**
     * Loads the content of the view
     */
    public abstract void LoadContent() throws SQLException, IOException;

    /**
     * Loads the child view in the content area
     * @param viewName
     * @throws IOException
     */
    public void changeView(String viewName) throws IOException {
        changeView(viewName, 0, 0);
    }

    /**
     * Loads the child view in the content area
     * @param viewName
     * @param userId
     * @throws IOException
     */
    public void changeView(String viewName, int userId) throws IOException {
        changeView(viewName, userId, 0);
    }

    /**
     * Loads the child view in the content area
     * @param viewName
     * @param userId
     * @param entityId
     * @throws IOException
     */
    public void changeView(String viewName,
                           int userId,
                           int entityId) throws IOException {
        try{
            FXMLLoader fxml = new FXMLLoader(Objects.requireNonNull(getClass().getResource(path + viewName)));

            this.contentArea.getChildren().removeAll();
            Parent view = fxml.load();
            this.contentArea.getChildren().setAll(view);

            Controller viewController = fxml.getController();
            viewController.setContentArea(this.contentArea);
            viewController.setUserId(userId);
            viewController.setEntityId(entityId);
            viewController.LoadContent();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void SwitchScene(ActionEvent event, String sceneName) throws IOException {
         root = FXMLLoader.load(getClass().getResource(path + sceneName));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    // </editor-fold>

}



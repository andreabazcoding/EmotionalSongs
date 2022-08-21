package com.studenti.uninsubria.emotionalsongs.ClientES.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

/**
 * @author luqmanasghar
 */
public abstract class Controller {

    public static final String path = "/View/";

    private int userId;

    private int entityId;

    @FXML
    protected StackPane contentArea;

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

    /**
     * Loads the content of the view
     */
    public abstract void LoadContent();

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
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void LoadSubView(BorderPane subBorderPane, String viewName){
        try{
            FXMLLoader fxml = new FXMLLoader(Objects.requireNonNull(getClass().getResource(path + viewName)));

            subBorderPane.getChildren().removeAll();
            Parent view = fxml.load();
            this.contentArea.getChildren().setAll(view);

            Controller viewController = fxml.getController();
            viewController.setUserId(userId);
            viewController.setEntityId(entityId);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}

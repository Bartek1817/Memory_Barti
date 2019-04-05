/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory_barti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Marlena
 */
public class Memory_Barti extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Memory Game");
        primaryStage.setResizable(false);

        root.getChildren().clear();
        Menu.menu(root, primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory_barti;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Marlena
 */
public class Menu {

    static void menu(BorderPane root, Stage primaryStage) {

        ImageView Logo = new ImageView("file:logo.png");
        Logo.setLayoutY(50);
        Logo.setLayoutX(300);
       

        Text Start = new Text("Start");
        Start.setStyle("-fx-font-size: 60pt;");
        Start.setFill(Color.WHITE);
        Start.setLayoutY(440);
        Start.setLayoutX(470);
        Start.setPickOnBounds(true);

        Text Help = new Text("Pomoc");
        Help.setStyle("-fx-font-size: 60pt;");
        Help.setFill(Color.WHITE);
        Help.setLayoutY(540);
        Help.setLayoutX(475);
        Help.setPickOnBounds(true);

        Text Back = new Text("Powrót");
        Back.setStyle("-fx-font-size: 60pt;");
        Back.setFill(Color.WHITE);
        Back.setLayoutY(540);
        Back.setLayoutX(475);
        Back.setPickOnBounds(true);

        Text Instruction = new Text("Cala instrukcja do gry ble ble ble Cala instrukcja do gry ble ble ble Cala instrukcja do gry ble ble ble Cala instrukcja do gry ble ble ble");
        Instruction.setStyle("-fx-font-size: 20pt;");
        Instruction.setFill(Color.WHITE);
        Instruction.setLayoutY(140);
        Instruction.setLayoutX(275);
        Instruction.setPickOnBounds(true);
        Instruction.setWrappingWidth(400);

        root.getChildren().add(Start);
        root.getChildren().add(Help);
        root.getChildren().add(Logo);

        Start.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            Start.setFill(Color.WHITE);
        });
        Start.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            Start.setFill(Color.RED);
        });
        Start.setOnMouseClicked((MouseEvent e) -> {
            root.getChildren().clear();
            Game.menu(root, primaryStage);
        });

        Back.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            Back.setFill(Color.WHITE);
        });
        Back.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            Back.setFill(Color.RED);
        });
        Back.setOnMouseClicked((MouseEvent e) -> {
            root.getChildren().clear();
            root.getChildren().add(Start);
            root.getChildren().add(Help);
            root.getChildren().add(Logo);
        });

        Help.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            Help.setFill(Color.WHITE);
        });
        Help.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            Help.setFill(Color.RED);
        });

        Help.setOnMouseClicked((MouseEvent e) -> {
            root.getChildren().clear();
            root.getChildren().add(Back);
            root.getChildren().add(Instruction);
        });
    }
}

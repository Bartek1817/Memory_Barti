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
        root.getChildren().add(Logo);

        Text Start = new Text("Start");
        Start.setStyle("-fx-font-size: 40pt;");
        Start.setFill(Color.WHITE);
        Start.setLayoutY(470);
        Start.setLayoutX(290);
        Start.setPickOnBounds(true);
        root.getChildren().add(Start);

        Text Left = new Text("<-");
        Left.setStyle("-fx-font-size: 40pt;");
        Left.setFill(Color.WHITE);
        Left.setLayoutY(412);
        Left.setLayoutX(472);
        Left.setPickOnBounds(true);
        root.getChildren().add(Left);

        Text Category = new Text("Kategoria");
        Category.setStyle("-fx-font-size: 30pt;");
        Category.setFill(Color.WHITE);
        Category.setLayoutY(410);
        Category.setLayoutX(525);
        Category.setPickOnBounds(true);
        root.getChildren().add(Category);

        Text Right = new Text("->");
        Right.setStyle("-fx-font-size: 40pt;");
        Right.setFill(Color.WHITE);
        Right.setLayoutY(412);
        Right.setLayoutX(690);
        Right.setPickOnBounds(true);
        root.getChildren().add(Right);

        Text NameCategory = new Text("Zwierzęta");
        NameCategory.setStyle("-fx-font-size: 40pt;");
        NameCategory.setFill(Color.WHITE);
        NameCategory.setLayoutY(470);
        NameCategory.setLayoutX(500);
        NameCategory.setPickOnBounds(true);
        root.getChildren().add(NameCategory);

        Text Help = new Text("Pomoc");
        Help.setStyle("-fx-font-size: 40pt;");
        Help.setFill(Color.WHITE);
        Help.setLayoutY(470);
        Help.setLayoutX(800);
        Help.setPickOnBounds(true);
        root.getChildren().add(Help);

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

        Start.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            Start.setFill(Color.WHITE);
        });
        Start.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            Start.setFill(Color.RED);
        });
        Start.setOnMouseClicked((MouseEvent e) -> {
            root.getChildren().clear();
            root.getChildren().clear();
            switch (NameCategory.getText()) {
                case "Zwierzęta":
                    Game.menu(root, primaryStage, 'z');
                    break;
                case "Budowle":
                    Game.menu(root, primaryStage, 'b');
                    break;
                default:
                    Game.menu(root, primaryStage, 'p');
                    break;
            }
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
            root.getChildren().add(Category);
            root.getChildren().add(Left);
            root.getChildren().add(Right);
            root.getChildren().add(NameCategory);

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

        Left.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            Left.setFill(Color.WHITE);
        });
        Left.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            Left.setFill(Color.RED);
        });
        Left.setOnMouseClicked((MouseEvent e) -> {
            switch (NameCategory.getText()) {
                case "Zwierzęta":
                    NameCategory.setText("Pojazdy");
                    break;
                case "Pojazdy":
                    NameCategory.setText("Budowle");
                    break;
                default:
                    NameCategory.setText("Zwierzęta");
                    break;
            }
        });
        Right.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            Right.setFill(Color.WHITE);
        });
        Right.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            Right.setFill(Color.RED);
        });
        Right.setOnMouseClicked((MouseEvent e) -> {
            switch (NameCategory.getText()) {
                case "Zwierzęta":
                    NameCategory.setText("Budowle");
                    break;
                case "Budowle":
                    NameCategory.setText("Pojazdy");
                    break;
                default:
                    NameCategory.setText("Zwierzęta");
                    break;
            }
        });
    }
}

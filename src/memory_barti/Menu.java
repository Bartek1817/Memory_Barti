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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Marlena
 */
public class Menu {

    static void menu(BorderPane root, Stage primaryStage) {

        ImageView Logo = new ImageView("file:img/logo.png");
        Logo.setLayoutY(50);
        Logo.setLayoutX(300);
        root.getChildren().add(Logo);

        Text Start = new Text("Start");
        Start.setStyle("-fx-font-size: 65pt;");
        Start.setFill(Color.WHITE);
        Start.setLayoutY(415);
        Start.setLayoutX(522);
        Start.setPickOnBounds(true);
        root.getChildren().add(Start);

        Text LeftLevel = new Text("<-");
        LeftLevel.setStyle("-fx-font-size: 40pt;");
        LeftLevel.setFill(Color.WHITE);
        LeftLevel.setLayoutY(512);
        LeftLevel.setLayoutX(205);
        LeftLevel.setPickOnBounds(true);
        root.getChildren().add(LeftLevel);

        Text Level = new Text("Poziom");
        Level.setStyle("-fx-font-size: 30pt;");
        Level.setFill(Color.WHITE);
        Level.setLayoutY(510);
        Level.setLayoutX(255);
        Level.setPickOnBounds(true);
        root.getChildren().add(Level);

        Text RightLevel = new Text("->");
        RightLevel.setStyle("-fx-font-size: 40pt;");
        RightLevel.setFill(Color.WHITE);
        RightLevel.setLayoutY(512);
        RightLevel.setLayoutX(383);
        RightLevel.setPickOnBounds(true);
        root.getChildren().add(RightLevel);

        Text NameLevel = new Text("Łatwy");
        NameLevel.setStyle("-fx-font-size: 40pt;");
        NameLevel.setFill(Color.WHITE);
        NameLevel.setLayoutY(570);
        NameLevel.setLayoutX(255);
        NameLevel.setPickOnBounds(true);
        root.getChildren().add(NameLevel);

        Text Left = new Text("<-");
        Left.setStyle("-fx-font-size: 40pt;");
        Left.setFill(Color.WHITE);
        Left.setLayoutY(512);
        Left.setLayoutX(472);
        Left.setPickOnBounds(true);
        root.getChildren().add(Left);

        Text Category = new Text("Kategoria");
        Category.setStyle("-fx-font-size: 30pt;");
        Category.setFill(Color.WHITE);
        Category.setLayoutY(510);
        Category.setLayoutX(525);
        Category.setPickOnBounds(true);
        root.getChildren().add(Category);

        Text Right = new Text("->");
        Right.setStyle("-fx-font-size: 40pt;");
        Right.setFill(Color.WHITE);
        Right.setLayoutY(512);
        Right.setLayoutX(690);
        Right.setPickOnBounds(true);
        root.getChildren().add(Right);

        Text NameCategory = new Text("Zwierzęta");
        NameCategory.setStyle("-fx-font-size: 40pt;");
        NameCategory.setFill(Color.WHITE);
        NameCategory.setLayoutY(570);
        NameCategory.setLayoutX(500);
        NameCategory.setPickOnBounds(true);
        root.getChildren().add(NameCategory);

        Text Help = new Text("Pomoc");
        Help.setStyle("-fx-font-size: 40pt;");
        Help.setFill(Color.WHITE);
        Help.setLayoutY(572);
        Help.setLayoutX(800);
        Help.setPickOnBounds(true);
        root.getChildren().add(Help);

        Text Back = new Text("Powrót");
        Back.setStyle("-fx-font-size: 60pt;");
        Back.setFill(Color.WHITE);
        Back.setLayoutY(540);
        Back.setLayoutX(475);
        Back.setPickOnBounds(true);

        Text Instruction = new Text("Memory_Barti to typowa gra pamięciowa w której "
                + "gracz ma zadanie znaleźć pary takich samych kart. Rozgrywka "
                + "kończy się wtedy gdy uda się odnaleźć wszystkie z nich.\n \n Gracz ma "
                + "możliwość wyboru poziomu trudności jak również może zdecydować jaka kategoria kart będzie wyświetlana.\n\n"
                + "                                           Grę stworzył Bartłomiej Żmuda");
        
        Instruction.setStyle("-fx-font-size: 20pt;");
        Instruction.setFill(Color.WHITE);
        Instruction.setLayoutY(140);
        Instruction.setLayoutX(275);
        Instruction.setPickOnBounds(true);
        Instruction.setWrappingWidth(600);
        Instruction.setTextAlignment(TextAlignment.JUSTIFY);

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
                    Game.menu(root, primaryStage, 'z', NameLevel.getText());
                    break;
                case "Budowle":
                    Game.menu(root, primaryStage, 'b', NameLevel.getText());
                    break;
                default:
                    Game.menu(root, primaryStage, 'p', NameLevel.getText());
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
            root.getChildren().add(Level);
            root.getChildren().add(LeftLevel);
            root.getChildren().add(RightLevel);
            root.getChildren().add(NameLevel);

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

        LeftLevel.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            LeftLevel.setFill(Color.WHITE);
        });
        LeftLevel.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            LeftLevel.setFill(Color.RED);
        });
        LeftLevel.setOnMouseClicked((MouseEvent e) -> {
            switch (NameLevel.getText()) {
                case "Trudny":
                    NameLevel.setText("Średni");
                    break;
                case "Średni":
                    NameLevel.setText("Łatwy");
                    break;
                default:
                    NameLevel.setText("Trudny");
                    break;
            }
        });
        RightLevel.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            RightLevel.setFill(Color.WHITE);
        });
        RightLevel.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            RightLevel.setFill(Color.RED);
        });
        RightLevel.setOnMouseClicked((MouseEvent e) -> {
            switch (NameLevel.getText()) {
                case "Łatwy":
                    NameLevel.setText("Średni");
                    break;
                case "Średni":
                    NameLevel.setText("Trudny");
                    break;
                default:
                    NameLevel.setText("Łatwy");
                    break;
            }
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

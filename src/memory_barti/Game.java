/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory_barti;

import Dane.Card;
import Dane.Controller;
import Dane.KTimer;
import java.util.ArrayList;
import java.util.Collections;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Marlena
 */
public class Game {

    public static ArrayList<Card> createCard(Controller controller) { // Tworzenie Kart
        int j = 0;
        ArrayList<Card> listCard = new ArrayList<Card>();

        for (int i = 0; i < 18; i++) // Pętla do tworzenia Kart
        {
            j = i / 2; // Pary kart takich samych
            Card card = new Card(i + 100, "file:karta.jpg", "file:" + j + ".png", j, controller);
            listCard.add(card);
        }
        return listCard;
    }

    static ArrayList<Card> mashupCards(ArrayList<Card> Cards) { // mieszanie Kart
        Collections.shuffle(Cards);
        int y = 0;
        int z = 0;
        for (int i = 0; i < 18; i++) // Pętla do Rozmieszania Kart
        {
            if (i == 6 || i == 12) {  // Po 6 kart w rzędzie
                y++;
                z = 0;
            }
            Cards.get(i).setLayoutX(50 + z * 150);
            Cards.get(i).setPositionX(50 + z * 150);
            Cards.get(i).setLayoutY(70 + y * 170);
            Cards.get(i).setPositionY(70 + y * 170);
            z++;
        }
        return Cards;
    }

    static void showAllCards(BorderPane root, ArrayList<Card> Cards) { // Wyświetlanie Kart
        for (int i = 0; i < 18; i++) {
            root.getChildren().add(Cards.get(i));
        }
    }

    public static void hideCards(Controller controller) {
        controller.getRoot().getChildren().remove(controller.getList2().get(0));
        controller.getRoot().getChildren().remove(controller.getList2().get(1));

    }

    public static void summaryFunction(Controller controller) {

        Text Summary = new Text("Gratulację!");
        Summary.setStyle("-fx-font-size: 90pt;");
        Summary.setFill(Color.WHITE);
        Summary.setLayoutY(350);
        Summary.setLayoutX(250);
        Summary.setPickOnBounds(true);
        controller.getRoot().getChildren().add(Summary);
    }

    static void menu(BorderPane root, Stage primaryStage) {

        Controller controller = new Controller(root, primaryStage);
        ArrayList<Card> listCards = mashupCards(createCard(controller));
        showAllCards(root, listCards);
        controller.setListCards(listCards);

        KTimer ktimer = new KTimer();
        Text timeText = new Text(ktimer.getSspTime().get());
        timeText.setFill(Color.WHITE);
        timeText.setStyle("-fx-font-size: 40pt;");
        timeText.setLayoutY(200);
        timeText.setLayoutX(930);
        root.getChildren().add(timeText);
        ktimer.startTimer(0);
        ktimer.getSspTime().addListener(new InvalidationListener() {

        @Override
        public void invalidated(Observable observable) {
            timeText.setText(ktimer.getSspTime().get());
        }
    });
        Text Time = new Text("Twój Czas: ");
        Time.setStyle("-fx-font-size: 40pt;");
        Time.setFill(Color.WHITE);
        Time.setLayoutY(100);
        Time.setLayoutX(920);
        Time.setPickOnBounds(true);
        root.getChildren().add(Time);

        Text ReStart = new Text("Restart");
        ReStart.setStyle("-fx-font-size: 40pt;");
        ReStart.setFill(Color.WHITE);
        ReStart.setLayoutY(325);
        ReStart.setLayoutX(970);
        ReStart.setPickOnBounds(true);
        root.getChildren().add(ReStart);

        ReStart.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            ReStart.setFill(Color.WHITE);
        });
        ReStart.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            ReStart.setFill(Color.RED);
        });
        ReStart.setOnMouseClicked((MouseEvent e) -> {
            root.getChildren().clear();
            Game.menu(root, primaryStage);
        });

        Text Back = new Text("Powrót");
        Back.setStyle("-fx-font-size: 30pt;");
        Back.setFill(Color.WHITE);
        Back.setLayoutY(550);
        Back.setLayoutX(1000);
        Back.setPickOnBounds(true);
        root.getChildren().add(Back);

        Back.setOnMouseExited((MouseEvent e) -> { // Po zjechaniu wykonaj
            Back.setFill(Color.WHITE);
        });
        Back.setOnMouseEntered((MouseEvent e) -> { // Po najechaniu wykonaj
            Back.setFill(Color.RED);
        });
        Back.setOnMouseClicked((MouseEvent e) -> {
            root.getChildren().clear();
            Menu.menu(root, primaryStage);
        });

    }
}

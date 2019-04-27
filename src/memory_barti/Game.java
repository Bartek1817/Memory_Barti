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
import java.util.Random;
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
public class Game {

    public static ArrayList<Card> createCard(Controller controller, char category, String level) { // Tworzenie Kart
        ArrayList<Card> listCard = new ArrayList<Card>();

        if (!level.equals("Trudny")) {
            int front = new Random().nextInt(5);
            for (int i = 0; i < 18; i++) // Pętla do tworzenia Kart
            {
                Card card = new Card(i + 100, "file:karta" + front + ".jpg", "file:" + category + i / 2 + ".png", i / 2, controller);
                listCard.add(card);
            }
        } else {
            for (int i = 0; i < 18; i++) {
                Card card = new Card(i + 100, "file:karta" + new Random().nextInt(5) + ".jpg", "file:" + category + i / 2 + ".png", i / 2, controller);
                listCard.add(card);
            }
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

    static void flipAllCards(Controller controller, String level) {
        int time;
        if (level.equals("Łatwy")) {
            time = 1750;
        } else {
            time = 500;
        }
        for (int i = 0; i < controller.getListCard().size(); i++) {
            controller.getListCard().get(i).flipCard();
        }
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < controller.getListCard().size(); i++) {
                    controller.getListCard().get(i).flipCard();
                }
            }
        },
                time
        );

    }

    public static void summaryFunction(Controller controller) {

        controller.getKtimer().stopTimer();
        Text Summary = new Text("Gratulację!");
        Summary.setStyle("-fx-font-size: 90pt;");
        Summary.setFill(Color.WHITE);
        Summary.setLayoutY(200);
        Summary.setLayoutX(250);
        Summary.setPickOnBounds(true);
        controller.getRoot().getChildren().add(Summary);

        Text Time = new Text("Twój Czas to: \n" + controller.getKtimer().getSspTime().get());
        Time.setStyle("-fx-font-size: 50pt;");
        Time.setFill(Color.WHITE);
        Time.setLayoutY(300);
        Time.setLayoutX(250);
        Time.setPickOnBounds(true);
        controller.getRoot().getChildren().add(Time);
    }

    static void menu(BorderPane root, Stage primaryStage, char category, String level) {

        KTimer ktimer = new KTimer();
        Controller controller = new Controller(root, primaryStage, ktimer);
        ArrayList<Card> listCards = mashupCards(createCard(controller, category, level));
        showAllCards(root, listCards);
        controller.setListCards(listCards);

        if (level.equals("Łatwy") || level.equals("Średni")) {
            flipAllCards(controller, level);
        }

        controller.getKtimer().startTimer(0);

        ImageView Logo = new ImageView("file:logo200.png");
        Logo.setLayoutY(50);
        Logo.setLayoutX(910);
        root.getChildren().add(Logo);

        Text ReStart = new Text("Restart");
        ReStart.setStyle("-fx-font-size: 40pt;");
        ReStart.setFill(Color.WHITE);
        ReStart.setLayoutY(425);
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
            Game.menu(root, primaryStage, category, level);
        });

        Text Back = new Text("Powrót");
        Back.setStyle("-fx-font-size: 40pt;");
        Back.setFill(Color.WHITE);
        Back.setLayoutY(530);
        Back.setLayoutX(970);
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

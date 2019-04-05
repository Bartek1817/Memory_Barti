/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory_barti;

import Dane.Card;
import Dane.Controller;
import java.util.ArrayList;
import java.util.Collections;
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
    
    static void menu(BorderPane root, Stage primaryStage) {
        
        Controller controller = new Controller();
        ArrayList<Card> listCards = mashupCards(createCard(controller));
        showAllCards(root, listCards);
        //  int count = 9;
        controller.setListCards(listCards);
        //  ArrayList<Card> list = new ArrayList<Card>();
        Text ReStart = new Text("Restart");
        ReStart.setStyle("-fx-font-size: 50pt;");
        ReStart.setFill(Color.WHITE);
        ReStart.setLayoutY(250);
        ReStart.setLayoutX(950);
        ReStart.setPickOnBounds(true);
        root.getChildren().add(ReStart);


        /*
        for (int i = 0; i < 18; i++) {
            if (listCards.get(i).isInverted()) {
                list.add(listCards.get(i));
            }
            if (list.size() == 2) {
                if ((int) list.get(0).getCouple() == (int) list.get(1).getCouple()) {
                    root.getChildren().remove(list.get(0));
                    root.getChildren().remove(list.get(1));
                    count--;
                    list.clear();
                    if (count == 0) {
                        // Wynik Końcowy
                    }
                    break;
                } else {
                    list.get(0).flipCard();
                    list.get(1).flipCard();
                    list.clear();
                    break;
                }
            }
            if (i == 17) {
                list.clear();
            }
        }
         */
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
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dane;

import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import memory_barti.Game;

/**
 *
 * @author Marlena
 */
public class Controller {

    ArrayList<Card> listCards;
    ArrayList<Card> list2;
    int points;
    int maxpoints;
    private final BorderPane root;
    private final Stage primaryStage;
    KTimer ktimer;
    Text ClickAmount;
    int click;

    public Controller(BorderPane root, Stage primaryStage, KTimer ktimer) {
        this.listCards = null;
        this.list2 = new ArrayList<Card>();
        this.points = 0;
        this.maxpoints = 9;
        this.root = root;
        this.primaryStage = primaryStage;
        this.ktimer = ktimer;
        this.click = 0;
        this.ClickAmount = new Text("Ilość Kliknięć \n" + "         " + click);
        ClickAmount.setStyle("-fx-font-size: 35pt;");
        ClickAmount.setFill(Color.WHITE);
        ClickAmount.setLayoutY(275);
        ClickAmount.setLayoutX(930);
        ClickAmount.setPickOnBounds(true);
        root.getChildren().add(ClickAmount);
    }

    public KTimer getKtimer() {
        return ktimer;
    }

    public ArrayList<Card> getListCard() {
        return listCards;
    }

    public void setListCards(ArrayList<Card> listCards) {
        this.listCards = listCards;
    }

    public ArrayList<Card> getList2() {
        return list2;
    }

    public void addClickAmount(int click) {
        ClickAmount.setText("Ilość Kliknięć \n" + "         " + click);
    }

    public void checkCard(Card card) {

        list2.add(card);

        if (this.list2.size() == 2) {
            if (this.list2.get(0).getCouple() == this.list2.get(1).getCouple()) {
                this.points++;
                Game.hideCards(this);
                list2.clear();
                if (this.points == this.maxpoints) { // end
                    Game.summaryFunction(this);
                }

            } else {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                    @Override
                    public void run() {
                        list2.get(0).flipCard();
                        list2.get(1).flipCard();
                        list2.clear();
                    }
                },
                        400
                );

            }
        }
    }

    /**
     * @return the root
     */
    public BorderPane getRoot() {
        return root;
    }

    /**
     * @return the primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

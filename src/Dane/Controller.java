/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dane;

import java.util.ArrayList;

/**
 *
 * @author Marlena
 */
public class Controller {

    ArrayList<Card> listCards;
    ArrayList<Card> list2;

    public Controller() {
        this.listCards = null;
        this.list2 = new ArrayList<Card>();
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

    public void checkCard(Card card) {

        list2.add(card);

        if (this.list2.size() == 2) {
            if (this.list2.get(0).getCouple() == this.list2.get(1).getCouple()) {

                list2.clear();

            } else {

                list2.get(0).flipCard();
                list2.get(1).flipCard();
                list2.clear();
            }
        }
    }
}
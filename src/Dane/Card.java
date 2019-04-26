/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Marlena
 */
public class Card extends ImageView {

    int id;
    int x;
    int y;
    Image back;
    Image front;
    boolean inverted;
    int couple;
    Controller controller;

    public Card(int id, String back, String front, int couple, Controller controller) {
        super(back);
        this.id = id;
        this.x = 0;
        this.y = 0;
        this.back = new Image(back);
        this.front = new Image(front);
        this.inverted = false;
        this.couple = couple;
        this.addEvenHandler();
        this.controller = controller;
    }

    public int getIdCard() {
        return id;
    }

    public void setIdCard(int id) {
        assert (id < 0);
        this.id = id;
    }

    public int getPositionX() {
        return x;
    }

    public void setPositionX(int x) {
        this.x = x;
    }

    public int getPositionY() {
        return y;
    }

    public void setPositionY(int y) {
        this.y = y;
    }

    public boolean isInverted() {
        return inverted;
    }

    public Image getBack() {
        return back;
    }

    public void setBack(Image back) {
        this.back = back;
    }

    public Image getFront() {
        return front;
    }

    public void setFront(Image front) {
        this.front = front;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public int getCouple() {
        return couple;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public void flipCard() {
        if (this.inverted == false) {
            this.setImage(front);
            this.inverted = true;
        } else {
            this.setImage(back);
            this.inverted = false;
        }
    }

    public final void addEvenHandler() {
        this.setOnMouseClicked((MouseEvent e) -> {
            if (this.inverted == false && this.controller.getList2().size() < 2) { // blokada żeby tylko 2 karty mogł być odwrócone
                controller.addClickAmount(++controller.click);
                flipCard();
                this.controller.checkCard(this);
            }
        });
    }
}

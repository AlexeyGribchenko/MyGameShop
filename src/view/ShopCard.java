package view;

import javax.swing.*;

public class ShopCard extends GameCardView {

    public ShopCard(String name, String description, int price, ImageIcon image, ImageIcon cartIcon, ImageIcon wishListIcon, ImageIcon removeIcon) {
        super(name, description, price, image, cartIcon, wishListIcon, removeIcon);
        getStartGameBtn().setVisible(false);
        getRemoveBtn().setVisible(false);
    }
}

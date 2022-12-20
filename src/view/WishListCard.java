package view;

import javax.swing.*;

public class WishListCard extends GameCardView {
    public WishListCard(String name, String description, int price, ImageIcon image, ImageIcon cartIcon, ImageIcon wishListIcon, ImageIcon removeIcon) {
        super(name, description, price, image, cartIcon, wishListIcon, removeIcon);
        getAddToWishListBtn().setVisible(false);
        getStartGameBtn().setVisible(false);
    }
}

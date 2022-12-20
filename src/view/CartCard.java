package view;

import javax.swing.*;

public class CartCard extends GameCardView {
    public CartCard(String name, String description, int price, ImageIcon image, ImageIcon cartIcon, ImageIcon wishListIcon, ImageIcon removeIcon) {
        super(name, description, price, image, cartIcon, wishListIcon, removeIcon);
        getAddToCartBtn().setVisible(false);
        getAddToWishListBtn().setVisible(false);
        getStartGameBtn().setVisible(false);
    }
}

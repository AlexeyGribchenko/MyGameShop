package view;

import javax.swing.*;

public class LibraryCard extends GameCardView {
    public LibraryCard(String name, String description, int price, ImageIcon image, ImageIcon cartIcon, ImageIcon wishListIcon, ImageIcon removeIcon) {
        super(name, description, price, image, cartIcon, wishListIcon, removeIcon);
        getAddToCartBtn().setVisible(false);
        getPriceLabel().setVisible(false);
        getAddToWishListBtn().setVisible(false);
        getRemoveBtn().setVisible(false);
    }
}

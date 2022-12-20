package view;

import mycomponents.MyButton;
import mycomponents.MyLabel;
import mycomponents.MyTextArea;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class GameCardView extends JPanel {

    private final MyButton addToCartBtn;
    private final MyButton addToWishListBtn;
    private final MyButton startGameBtn;
    private final MyButton removeBtn;
    private final MyLabel priceLabel;
    public GameCardView(String name, String description, int price, ImageIcon image, ImageIcon cartIcon, ImageIcon wishListIcon, ImageIcon removeIcon) {

        GroupLayout gameCardGL = new GroupLayout(this);
        setLayout(gameCardGL);
        setBackground(Color.decode(Settings.Color.DARK_BLUE));

        addToCartBtn = new MyButton();
        addToCartBtn.setBackground(Color.decode(Settings.Color.DARK_GREEN));
        addToWishListBtn = new MyButton();
        addToWishListBtn.setBackground(Color.decode(Settings.Color.DARK_GREEN));
        startGameBtn = new MyButton("ИГРАТЬ");
        removeBtn = new MyButton();
        removeBtn.setBackground(Color.decode(Settings.Color.DARK_GREEN));

        addToCartBtn.setIcon(cartIcon);
        addToCartBtn.setIconTextGap(0);

        addToWishListBtn.setIcon(wishListIcon);
        addToWishListBtn.setIconTextGap(0);

        removeBtn.setIcon(removeIcon);
        removeBtn.setIconTextGap(0);

        MyTextArea nameLabel = new MyTextArea(name);
        nameLabel.setLineWrap(true);
        nameLabel.setWrapStyleWord(true);
        MyTextArea descriptionTextArea = new MyTextArea(description);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        priceLabel = new MyLabel(((Integer)price).toString());

        MyLabel logoIcon = new MyLabel(image);

        setPreferredSize(new Dimension(0, 130));
        setMaximumSize(new Dimension(Settings.GameCard.CARD_WIDTH, 130));

        gameCardGL.setHorizontalGroup(
                gameCardGL.createSequentialGroup()
                        .addComponent(logoIcon, Settings.GameCard.IMAGE_WIDTH, GroupLayout.DEFAULT_SIZE, Settings.GameCard.IMAGE_WIDTH) // обложка игры
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                        .addGroup(gameCardGL.createParallelGroup()
                                .addComponent(nameLabel, 120, 120, 120)
                                .addComponent(priceLabel, 0, GroupLayout.DEFAULT_SIZE, Settings.GameCard.PRICE_WIDTH)
                                .addComponent(startGameBtn, 0, 100, 100)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descriptionTextArea, 250, 400, 400)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                        .addGroup(gameCardGL.createParallelGroup()
                                .addComponent(addToWishListBtn, 0, Settings.GameCard.BTN_WIDTH, Settings.GameCard.BTN_WIDTH)
                                .addComponent(removeBtn, 0, Settings.GameCard.BTN_WIDTH, Settings.GameCard.BTN_WIDTH)
                                .addComponent(addToCartBtn, 0, Settings.GameCard.BTN_WIDTH, Settings.GameCard.BTN_WIDTH)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
        );
        gameCardGL.setVerticalGroup(
                gameCardGL.createParallelGroup()
                        .addComponent(logoIcon, Settings.GameCard.IMAGE_HEIGHT, GroupLayout.DEFAULT_SIZE, Settings.GameCard.IMAGE_HEIGHT)
                        .addGroup(
                                gameCardGL.createSequentialGroup()
                                        .addGroup(
                                                gameCardGL.createParallelGroup()
                                                        .addGroup(gameCardGL.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 12)
                                                                .addComponent(nameLabel)
                                                                .addComponent(priceLabel)
                                                                .addComponent(startGameBtn, 0, 50, 50)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        )
                                                        .addGroup(gameCardGL.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 12)
                                                                .addComponent(descriptionTextArea)
                                                        )
                                                        .addGroup(gameCardGL.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(addToWishListBtn, 0, Settings.GameCard.BTN_HEIGHT, Settings.GameCard.BTN_HEIGHT)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(removeBtn, 0, Settings.GameCard.BTN_HEIGHT, Settings.GameCard.BTN_HEIGHT)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(addToCartBtn, 0, Settings.GameCard.BTN_HEIGHT, Settings.GameCard.BTN_HEIGHT)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        )
                                        )
                        )
                );
    }

    public MyButton getAddToCartBtn() {
        return addToCartBtn;
    }

    public MyButton getAddToWishListBtn() {
        return addToWishListBtn;
    }

    public MyLabel getPriceLabel() {
        return priceLabel;
    }

    public MyButton getStartGameBtn() {
        return startGameBtn;
    }

    public MyButton getRemoveBtn() {
        return removeBtn;
    }
}

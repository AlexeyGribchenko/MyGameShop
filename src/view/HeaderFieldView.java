package view;

import mycomponents.MyButton;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class HeaderFieldView extends JPanel {

    private final MyButton loginNavigationBtn;
    private final MyButton wishListNavigationBtn;
    private final MyButton cartNavigationBtn;
    private final MyButton shopNavigationBtn;
    private final MyButton libraryNavigationBtn;

    public HeaderFieldView() {
        setBackground(Color.decode("#1B2838"));
        loginNavigationBtn = new MyButton("Войти");
        wishListNavigationBtn = new MyButton("Избранное");
        cartNavigationBtn = new MyButton("Корзина");
        shopNavigationBtn = new MyButton("Магазин");
        libraryNavigationBtn = new MyButton("Библиотека");

        GroupLayout headerGL = new GroupLayout(this);
        setLayout(headerGL);

        headerGL.setHorizontalGroup(headerGL.createSequentialGroup()
                .addComponent(libraryNavigationBtn, 0, 150, 150)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(shopNavigationBtn, 0, 150, 150)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wishListNavigationBtn, 0, 150, 150)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cartNavigationBtn, 0, 150, 150)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginNavigationBtn, 0, 150, 150)
        );
        headerGL.setVerticalGroup(
                headerGL.createSequentialGroup()
                        .addContainerGap(Settings.Gap.MIN_GAP, Settings.Gap.MIN_GAP)
                        .addGroup(headerGL.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(libraryNavigationBtn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(shopNavigationBtn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wishListNavigationBtn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cartNavigationBtn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loginNavigationBtn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                        .addContainerGap(Settings.Gap.MIN_GAP, Settings.Gap.MIN_GAP)
        );
    }

    public MyButton getLibraryNavigationBtn() {
        return libraryNavigationBtn;
    }

    public MyButton getWishListNavigationBtn() {
        return wishListNavigationBtn;
    }

    public MyButton getShopNavigationBtn() {
        return shopNavigationBtn;
    }

    public MyButton getLoginNavigationBtn() {
        return loginNavigationBtn;
    }

    public MyButton getCartNavigationBtn() {
        return cartNavigationBtn;
    }
}

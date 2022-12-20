package view;

import mycomponents.MyButton;
import mycomponents.MyLabel;
import mycomponents.MyTextField;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class WishListFieldView extends FieldView {
    private final MyTextField wishListSearchTF;
    private final MyButton wishListSearchNameBtn;
    private final MyButton sortIncreasinglyBtn;
    private final MyButton sortDecreasinglyBtn;

    public WishListFieldView() {

        super(new JPanel());
        setBackground(Color.decode(Settings.Color.DARK_BLUE));

        wishListSearchTF = new MyTextField("Поиск");
        wishListSearchTF.setName("Поиск");
        wishListSearchTF.setPreferredSize(new Dimension(200, 30));

        wishListSearchNameBtn = new MyButton("Найти");

        MyLabel sortingLabel = new MyLabel("Сортировка по");
        sortDecreasinglyBtn = new MyButton("Убыванию");
        sortIncreasinglyBtn = new MyButton("Возрастанию");

        gameProductsField.setLayout(new BoxLayout(gameProductsField, BoxLayout.PAGE_AXIS));
        gameProductsField.setBackground(Color.decode(Settings.Color.BLUE));
        JScrollPane gameProductsFieldScroll = new JScrollPane(gameProductsField);
        gameProductsFieldScroll.getVerticalScrollBar().setUnitIncrement(16);
        gameProductsFieldScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gameProductsFieldScroll.setBorder(BorderFactory.createEmptyBorder());

        GroupLayout wishListGL = new GroupLayout(this);
        setLayout(wishListGL);
        wishListGL.setHorizontalGroup(
                wishListGL.createSequentialGroup()
                        .addGroup(wishListGL.createParallelGroup()
                                .addComponent(sortingLabel, 100, 100, 120)
                                .addComponent(sortDecreasinglyBtn, 100, 100, 120)
                                .addComponent(sortIncreasinglyBtn, 100, 100, 120)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                        .addGroup(wishListGL.createParallelGroup()
                                .addGroup(wishListGL.createSequentialGroup()
                                        .addComponent(wishListSearchTF, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                                        .addComponent(wishListSearchNameBtn, 0, 60, 60)
                                )
                                .addComponent(gameProductsFieldScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );
        wishListGL.setVerticalGroup(
                wishListGL.createSequentialGroup()
                        .addGroup(wishListGL.createParallelGroup()
                                .addComponent(sortingLabel,0, GroupLayout.DEFAULT_SIZE, Settings.ShopField.MIN_FILED_HEIGHT)
                                .addComponent(wishListSearchTF, 30, GroupLayout.PREFERRED_SIZE, 30)
                                .addComponent(wishListSearchNameBtn, 30, GroupLayout.PREFERRED_SIZE, 30)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                        .addGroup(wishListGL.createParallelGroup()
                                .addGroup(wishListGL.createSequentialGroup()
                                        .addComponent(sortIncreasinglyBtn, 0, GroupLayout.DEFAULT_SIZE, Settings.ShopField.MIN_FILED_HEIGHT)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                                        .addComponent(sortDecreasinglyBtn, 0, GroupLayout.DEFAULT_SIZE, Settings.ShopField.MIN_FILED_HEIGHT)
                                )
                                .addComponent(gameProductsFieldScroll, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );
    }

    public MyButton getSortIncreasinglyBtn() {
        return sortIncreasinglyBtn;
    }

    public MyButton getSortDecreasinglyBtn() {
        return sortDecreasinglyBtn;
    }

    public MyButton getWishListSearchNameBtn() {
        return wishListSearchNameBtn;
    }

    public MyTextField getWishListSearchTF() {
        return wishListSearchTF;
    }
}

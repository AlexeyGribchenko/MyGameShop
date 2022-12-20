package view;

import mycomponents.MyButton;
import mycomponents.MyLabel;
import mycomponents.MyScrollBar;
import mycomponents.MyTextField;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class ShopFieldView extends FieldView {
    private final MyTextField shopSearchTF;
    private final MyButton shopSearchNameBtn;
    private final MyTextField shopMinPriceTF;
    private final MyTextField shopMaxPriceTF;
    private final MyButton shopSearchPriceBtn;
    private final MyButton sortIncreasinglyBtn;
    private final MyButton sortDecreasinglyBtn;

    public ShopFieldView() {

        super(new JPanel());

        setBackground(Color.decode(Settings.Color.DARK_BLUE));

        shopSearchTF = new MyTextField("Поиск");
        shopSearchTF.setName("Поиск");

        shopMaxPriceTF = new MyTextField("до");
        shopMaxPriceTF.setName("до");

        MyLabel rangeLabel = new MyLabel("Диапазон");
        shopMinPriceTF = new MyTextField("от");
        shopMinPriceTF.setName("от");

        shopSearchPriceBtn = new MyButton("Поиск");
        shopSearchNameBtn = new MyButton("Найти");

        MyLabel sortingLabel = new MyLabel("Сортировка по");
        sortDecreasinglyBtn = new MyButton("Убыванию");
        sortIncreasinglyBtn = new MyButton("Возрастанию");

        gameProductsField.setLayout(new BoxLayout(gameProductsField, BoxLayout.PAGE_AXIS));
        gameProductsField.setBackground(Color.decode(Settings.Color.BLUE));
        JScrollPane gameProductsFieldScroll = new JScrollPane(gameProductsField);
        gameProductsFieldScroll.getVerticalScrollBar().setUnitIncrement(16);
        gameProductsFieldScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gameProductsFieldScroll.setBorder(BorderFactory.createEmptyBorder());
        gameProductsFieldScroll.getVerticalScrollBar().setUI(new MyScrollBar());
        gameProductsFieldScroll.setViewportBorder(BorderFactory.createEmptyBorder());

        GroupLayout shopGL = new GroupLayout(this);
        setLayout(shopGL);
        shopGL.setHorizontalGroup(
                shopGL.createSequentialGroup()
                        .addGroup(shopGL.createParallelGroup()
                                .addComponent(rangeLabel, 120, 120, 120)
                                .addGroup(shopGL.createSequentialGroup()
                                        .addComponent(shopMinPriceTF, 50, 50, 50)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                                        .addComponent(shopMaxPriceTF, 50, 50, 50)
                                )
                                .addComponent(shopSearchPriceBtn, 120, 120, 120)
                                .addComponent(sortingLabel, 120, 120, 120)
                                .addComponent(sortDecreasinglyBtn, 120, 120, 120)
                                .addComponent(sortIncreasinglyBtn, 120, 120, 120)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                        .addGroup(shopGL.createParallelGroup()
                                .addGroup(shopGL.createSequentialGroup()
                                        .addComponent(shopSearchTF, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                                        .addComponent(shopSearchNameBtn,0, 60, 60)
                                )
                                .addComponent(gameProductsFieldScroll, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );
        shopGL.setVerticalGroup(
                shopGL.createSequentialGroup()
                        .addGroup(shopGL.createParallelGroup()
                                .addComponent(rangeLabel, 30, 30, 30)
                                .addComponent(shopSearchTF, 30, 30, 30)
                                .addComponent(shopSearchNameBtn, 30, 30, 30)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 10)
                        .addGroup(shopGL.createParallelGroup()
                                .addGroup(shopGL.createSequentialGroup()
                                        .addGroup(shopGL.createParallelGroup()
                                                .addComponent(shopMinPriceTF , 30, 30, 30)
                                                .addComponent(shopMaxPriceTF, 30, 30, 30)
                                        )
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 10)
                                        .addComponent(shopSearchPriceBtn, 0, 30, 30)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 10)
                                        .addComponent(sortingLabel,0, 30, 30)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 10)
                                        .addComponent(sortDecreasinglyBtn, 0, 30, 30)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 10)
                                        .addComponent(sortIncreasinglyBtn, 0, 30, 30)
                                )
                                .addComponent(gameProductsFieldScroll, 0, Short.MAX_VALUE, Short.MAX_VALUE)
                        )
        );
    }

    public MyButton getShopSearchNameBtn() {
        return shopSearchNameBtn;
    }

    public MyButton getShopSearchPriceBtn() {
        return shopSearchPriceBtn;
    }

    public MyButton getSortDecreasinglyBtn() {
        return sortDecreasinglyBtn;
    }

    public MyButton getSortIncreasinglyBtn() {
        return sortIncreasinglyBtn;
    }

    public MyTextField getShopMaxPriceTF() {
        return shopMaxPriceTF;
    }

    public MyTextField getShopMinPriceTF() {
        return shopMinPriceTF;
    }

    public MyTextField getShopSearchTF() {
        return shopSearchTF;
    }
}

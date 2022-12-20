package view;

import mycomponents.MyButton;
import mycomponents.MyLabel;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class CartFieldView extends FieldView {
    private final MyLabel priceLabelName;
    private final MyLabel priceLabel;
    private final MyButton buyBtn;

    public CartFieldView() {

        super(new JPanel());
        setBackground(Color.decode(Settings.Color.DARK_BLUE));

        priceLabel = new MyLabel("0");
        priceLabelName = new MyLabel("Итоговая цена:");
        buyBtn = new MyButton("Оплатить");

        gameProductsField.setLayout(new BoxLayout(gameProductsField, BoxLayout.PAGE_AXIS));
        gameProductsField.setBackground(Color.decode(Settings.Color.BLUE));
        JScrollPane gameProductsFieldScroll = new JScrollPane(gameProductsField);
        gameProductsFieldScroll.getVerticalScrollBar().setUnitIncrement(16);
        gameProductsFieldScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gameProductsFieldScroll.setBorder(BorderFactory.createEmptyBorder());

        GroupLayout shopGL = new GroupLayout(this);
        setLayout(shopGL);
        shopGL.setHorizontalGroup(
                shopGL.createSequentialGroup()
                        .addGroup(
                                shopGL.createParallelGroup()
                                        .addComponent(priceLabelName, 0, Settings.Field.ELEMENT_WIDTH, Settings.Field.ELEMENT_WIDTH)
                                        .addComponent(priceLabel, 0, Settings.Field.ELEMENT_WIDTH, Settings.Field.ELEMENT_WIDTH)
                                        .addComponent(buyBtn, 0, Settings.Field.ELEMENT_WIDTH, Settings.Field.ELEMENT_WIDTH)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                        .addComponent(gameProductsFieldScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        shopGL.setVerticalGroup(
                shopGL.createParallelGroup()
                        .addGroup(
                                shopGL.createSequentialGroup()
                                        .addComponent(priceLabelName, 0, Settings.Field.ELEMENT_HEIGHT, Settings.Field.ELEMENT_HEIGHT)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                                        .addComponent(priceLabel, 0, Settings.Field.ELEMENT_HEIGHT, Settings.Field.ELEMENT_HEIGHT)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                                        .addComponent(buyBtn, 0, Settings.Field.ELEMENT_HEIGHT, Settings.Field.ELEMENT_HEIGHT)
                        )
                        .addComponent(gameProductsFieldScroll, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public MyLabel getPriceLabel() {
        return priceLabel;
    }

    public MyButton getPayBtn() {
        return buyBtn;
    }

    public MyLabel getPriceLabelName() {
        return priceLabelName;
    }
}

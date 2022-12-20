package view;

import mycomponents.MyButton;
import mycomponents.MyTextField;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class LibraryFieldView extends FieldView {
    private final MyTextField librarySearchTF;
    private final MyButton librarySearchNameBtn;
    private final MyButton startGameBtn;

    public LibraryFieldView() {

        super(new JPanel());
        setBackground(Color.decode(Settings.Color.DARK_BLUE));

        startGameBtn = new MyButton("ИГРАТЬ");
        librarySearchTF = new MyTextField("Поиск");
        librarySearchTF.setName("Поиск");
        librarySearchNameBtn = new MyButton("Найти");

        gameProductsField.setLayout(new BoxLayout(gameProductsField, BoxLayout.PAGE_AXIS));
        gameProductsField.setBackground(Color.decode(Settings.Color.BLUE));
        JScrollPane gameProductsFieldScroll = new JScrollPane(gameProductsField);
        gameProductsFieldScroll.getVerticalScrollBar().setUnitIncrement(16);
        gameProductsFieldScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gameProductsFieldScroll.setBorder(BorderFactory.createEmptyBorder());

        GroupLayout libraryGL = new GroupLayout(this);
        setLayout(libraryGL);
        libraryGL.setHorizontalGroup(
                libraryGL.createSequentialGroup()
                        .addGroup(libraryGL.createParallelGroup()
                                .addGroup(libraryGL.createSequentialGroup()
                                        .addComponent(librarySearchTF, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                                        .addComponent(librarySearchNameBtn, 0, 60, 60)
                                )
                                .addComponent(gameProductsFieldScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );
        libraryGL.setVerticalGroup(
                libraryGL.createSequentialGroup()
                        .addGroup(libraryGL.createParallelGroup()
                                .addComponent(librarySearchTF, 30, GroupLayout.PREFERRED_SIZE, 30)
                                .addComponent(librarySearchNameBtn, 30, GroupLayout.PREFERRED_SIZE, 30)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Settings.Gap.MIN_GAP)
                        .addGroup(libraryGL.createParallelGroup()
                                .addComponent(gameProductsFieldScroll, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );

    }

    public MyButton getStartGameBtn() {
        return startGameBtn;
    }

    public MyTextField getLibrarySearchTF() {
        return librarySearchTF;
    }

    public MyButton getLibrarySearchNameBtn() {
        return librarySearchNameBtn;
    }
}

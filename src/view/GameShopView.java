package view;

import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class GameShopView extends JFrame {
    private final HeaderFieldView headerField;
    private final LibraryFieldView libraryField;
    private final ShopFieldView shopField;
    private final WishListFieldView wishListField;
    private final CartFieldView cartField;
    private final LoginFieldView loginField;

    private final JPanel extraPanel;
    private FieldView currentPanel;

    public GameShopView() {
        super("GameShop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setMinimumSize(new Dimension(Settings.Window.MIN_WIDTH, Settings.Window.MIN_HEIGHT));
        setPreferredSize(new Dimension(Settings.Window.MIN_WIDTH, Settings.Window.MIN_HEIGHT));

        extraPanel = new JPanel();
        extraPanel.setBackground(Color.decode(Settings.Color.DARK_BLUE));
        GroupLayout extraGL = new GroupLayout(extraPanel);
        extraPanel.setLayout(extraGL);

        shopField = new ShopFieldView();
        loginField = new LoginFieldView();

        wishListField = new WishListFieldView();
        cartField = new CartFieldView();
        libraryField = new LibraryFieldView();
        headerField = new HeaderFieldView();

        currentPanel = shopField;

        JPanel mainField = new JPanel();
        mainField.setBackground(Color.BLUE);
        GroupLayout mainFieldGL = new GroupLayout(mainField);


        mainFieldGL.setVerticalGroup(
                mainFieldGL.createSequentialGroup()
                        .addComponent(libraryField)
                        .addComponent(shopField)
                        .addComponent(wishListField)
                        .addComponent(cartField)
                        .addComponent(loginField)
                );
        mainFieldGL.setHorizontalGroup(
                mainFieldGL.createParallelGroup()
                        .addComponent(libraryField)
                        .addComponent(shopField, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(wishListField)
                        .addComponent(cartField)
                        .addComponent(loginField)
                );


        extraGL.setVerticalGroup(extraGL.createSequentialGroup()
                .addComponent(headerField, Settings.Header.HEIGHT, Settings.Header.HEIGHT, Settings.Header.HEIGHT)
                .addComponent(libraryField)
                .addComponent(shopField)
                .addComponent(wishListField)
                .addComponent(cartField)
                .addComponent(loginField)
                .addContainerGap(Settings.Gap.MIN_GAP, Settings.Gap.MIN_GAP)
        );
        extraGL.setHorizontalGroup(
                extraGL.createSequentialGroup()
                        .addContainerGap(Settings.Gap.MIN_GAP, Settings.Gap.MIN_GAP)
                        .addGroup(extraGL.createParallelGroup()
                                .addComponent(headerField, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(libraryField)
                                .addComponent(shopField)
                                .addComponent(wishListField)
                                .addComponent(cartField)
                                .addComponent(loginField)
                        )
                        .addContainerGap(Settings.Gap.MIN_GAP, Settings.Gap.MIN_GAP)
                );
        libraryField.setVisible(false);
        cartField.setVisible(false);
        wishListField.setVisible(false);
        loginField.setVisible(false);
        add(extraPanel);
        setVisible(true);
    }

    public CartFieldView getCartField() {
        return cartField;
    }

    public LibraryFieldView getLibraryField() {
        return libraryField;
    }

    public HeaderFieldView getHeaderField() {
        return headerField;
    }

    public ShopFieldView getShopField() {
        return shopField;
    }
    public LoginFieldView getLoginField() {
        return loginField;
    }
    public WishListFieldView getWishListField() {
        return wishListField;
    }

    public JPanel getExtraPanel() {
        return extraPanel;
    }

    public FieldView getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(FieldView currentPanel) {
        this.currentPanel = currentPanel;
    }

    public void alertUser(String alertMessage) {
        JOptionPane.showMessageDialog(this, alertMessage);
    }
}

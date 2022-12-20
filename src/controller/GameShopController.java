package controller;

import database.DataBase;
import database.UserAlreadyExistException;
import database.UserNotFoundException;
import model.*;
import mycomponents.MyButton;
import mycomponents.MyLabel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameShopController {
    private final GameShop model;
    private final GameShopView view;
    private final DataBase dataBase;

    GameShopController(GameShop model, GameShopView view) {
        this.model = model;
        this.view = view;
        dataBase = new DataBase();
    }

    public void initController() {
        view.addWindowListener(new ClosingWindowEventListener());

        NavigationEventListener navigationEventListener = new NavigationEventListener();
        view.getHeaderField().getCartNavigationBtn().addActionListener(navigationEventListener);
        view.getHeaderField().getWishListNavigationBtn().addActionListener(navigationEventListener);
        view.getHeaderField().getShopNavigationBtn().addActionListener(navigationEventListener);
        view.getHeaderField().getLibraryNavigationBtn().addActionListener(navigationEventListener);
        view.getHeaderField().getLoginNavigationBtn().addActionListener(navigationEventListener);

        view.getLoginField().getLoginBtn().setActionCommand("login");
        view.getLoginField().getRegisterBtn().setActionCommand("register");

        LoginEventListener loginEventListener = new LoginEventListener();
        view.getLoginField().getLoginBtn().addActionListener(loginEventListener);
        view.getLoginField().getRegisterBtn().addActionListener(loginEventListener);

        TextSearchEventListener textSearchEventListener = new TextSearchEventListener();
        view.getShopField().getShopSearchPriceBtn().setActionCommand("shop priceFind");
        view.getShopField().getShopSearchPriceBtn().addActionListener(textSearchEventListener);
        view.getShopField().getShopSearchNameBtn().setActionCommand("shop nameFind");
        view.getShopField().getShopSearchNameBtn().addActionListener(textSearchEventListener);
        view.getLibraryField().getLibrarySearchNameBtn().setActionCommand("library nameFind");
        view.getLibraryField().getLibrarySearchNameBtn().addActionListener(textSearchEventListener);
        view.getWishListField().getWishListSearchNameBtn().setActionCommand("wishlist nameFind");
        view.getWishListField().getWishListSearchNameBtn().addActionListener(textSearchEventListener);

        SortEventListener sortEventListener = new SortEventListener();
        view.getShopField().getSortIncreasinglyBtn().setActionCommand("inc shop");
        view.getShopField().getSortIncreasinglyBtn().addActionListener(sortEventListener);
        view.getShopField().getSortDecreasinglyBtn().setActionCommand("dec shop");
        view.getShopField().getSortDecreasinglyBtn().addActionListener(sortEventListener);
        view.getWishListField().getSortIncreasinglyBtn().setActionCommand("inc wishlist");
        view.getWishListField().getSortIncreasinglyBtn().addActionListener(sortEventListener);
        view.getWishListField().getSortDecreasinglyBtn().setActionCommand("dec wishlist");
        view.getWishListField().getSortDecreasinglyBtn().addActionListener(sortEventListener);

        view.getCartField().getPayBtn().setActionCommand("pay");
        view.getCartField().getPayBtn().addActionListener(new MoveProductEventListener());

        TextFocusListener textFocusListener = new TextFocusListener();
        view.getShopField().getShopMinPriceTF().addFocusListener(textFocusListener);
        view.getShopField().getShopMaxPriceTF().addFocusListener(textFocusListener);
        view.getShopField().getShopSearchTF().addFocusListener(textFocusListener);
        view.getLibraryField().getLibrarySearchTF().addFocusListener(textFocusListener);
        view.getWishListField().getWishListSearchTF().addFocusListener(textFocusListener);

        fillPanelWithGameProducts(view.getShopField().getGameProductsField(), dataBase.getFullProductNameList(), CardType.SHOP);
        setPanelVisible(view.getShopField());
    }

    private enum CardType {
        SHOP,
        LIBRARY,
        CART,
        WISH_LIST
    }

    private void loginUser(String name, String password) {
        try {
            User user = dataBase.getUser(name, password);
            if (!model.getCurrentUser().getUserName().equals("default"))
                dataBase.updateUser(model.getCurrentUser());
            model.setCurrentUser(user);
            view.alertUser("Вы успешно вошли!");
        } catch (UserNotFoundException e) {
            view.alertUser(e.getMessage());
        }
    }

    private void registerUser(String name, String password) {
        try {
            User newUser = new User(name, password);
            dataBase.addUser(newUser);
            if (!model.getCurrentUser().getUserName().equals("default")) {
                try {
                    dataBase.updateUser(model.getCurrentUser());
                } catch (UserNotFoundException ignored) {

                }
            }
            view.alertUser("Вы успешно зарегестрировались!");
            model.setCurrentUser(newUser);
        } catch (UserAlreadyExistException e) {
            view.alertUser(e.getMessage());
        }
    }

    private ArrayList<String> filterGameProductListByName(ArrayList<String> gameProductList, String filter) {
        ArrayList<String> newList = new ArrayList<>();
        for (String name : gameProductList) {
            if (name.contains(filter)) {
                newList.add(name);
            }
        }
        return newList;
    }

    private ArrayList<String> filterGameProductListByPrice(ArrayList<String> gameProductList, int min, int max) {
        ArrayList<String> newList = new ArrayList<>();
        for (String name : gameProductList) {
            if (dataBase.getGameProductByName(name).getPrice() > min && dataBase.getGameProductByName(name).getPrice() < max) {
                newList.add(name);
            }
        }
        return newList;
    }

    private ArrayList<String> sortIncreasingly(ArrayList<String> gameProductList) {
        ArrayList<String> newList = new ArrayList<>(gameProductList);
        for (int i = 0; i < newList.toArray().length; i++) {
            for (int j = i + 1; j < newList.toArray().length; j++) {
                if (dataBase.getGameProductByName(newList.get(i)).getPrice() > dataBase.getGameProductByName(newList.get(j)).getPrice()) {
                    String tmp = newList.get(i);
                    newList.set(i, newList.get(j));
                    newList.set(j, tmp);
                }
            }
        }
        return newList;
    }

    private ArrayList<String> sortDecreasingly(ArrayList<String> gameProductList) {
        ArrayList<String> newList = new ArrayList<>(gameProductList);
        for (int i = 0; i < newList.toArray().length; i++) {
            for (int j = i + 1; j < newList.toArray().length; j++) {
                if (dataBase.getGameProductByName(newList.get(i)).getPrice() < dataBase.getGameProductByName(newList.get(j)).getPrice()) {
                    String tmp = newList.get(i);
                    newList.set(i, newList.get(j));
                    newList.set(j, tmp);
                }
            }
        }
        return newList;
    }

    private GameCardView gameCardViewFactory(
            CardType type,
            String name,
            String description,
            int price,
            ImageIcon logoIcon,
            ImageIcon cartIcon,
            ImageIcon wishListIcon,
            ImageIcon removeIcon) {
        GameCardView card;
        switch (type) {
            case LIBRARY -> {
                return new LibraryCard(name, description, price, logoIcon, cartIcon, wishListIcon, removeIcon);
            }
            case SHOP -> {
                return new ShopCard(name, description, price, logoIcon, cartIcon, wishListIcon, removeIcon);
            }
            case WISH_LIST -> {
                card = new WishListCard(name, description, price, logoIcon, cartIcon, wishListIcon, removeIcon);
                card.getRemoveBtn().setActionCommand(name);
                card.getRemoveBtn().setName("wishlist");
                return card;
            }
            case CART -> {
                card = new CartCard(name, description, price, logoIcon, cartIcon, wishListIcon, removeIcon);
                card.getRemoveBtn().setActionCommand(name);
                card.getRemoveBtn().setName("cart");
                return card;
            }
            default -> {
                return new GameCardView(name, description, price, logoIcon, cartIcon, wishListIcon, removeIcon);
            }
        }
    }

    private void fillPanelWithGameProducts(JPanel panel, ArrayList<String> productNamesList, CardType type) {

        if (productNamesList.isEmpty()) {
            panel.removeAll();
            panel.add(new MyLabel(" Список пуст."));
            return;
        }
        panel.removeAll();
        GameCardView gameCardView;

        MoveProductEventListener moveProductEventListener = new MoveProductEventListener();

        for (String gameName : productNamesList) {

            gameCardView = gameCardViewFactory(
                    type,
                    dataBase.getGameProductByName(gameName).getName(),
                    dataBase.getGameProductByName(gameName).getDescription(),
                    dataBase.getGameProductByName(gameName).getPrice(),
                    dataBase.getImageIconByName(gameName),
                    dataBase.getImageIconByName("cart"),
                    dataBase.getImageIconByName("wishlist"),
                    dataBase.getImageIconByName("remove")
            );

            gameCardView.getAddToCartBtn().setActionCommand("cart " + gameName);
            gameCardView.getAddToWishListBtn().addActionListener(moveProductEventListener);
            gameCardView.getAddToWishListBtn().setActionCommand("wishlist " + gameName);
            gameCardView.getAddToCartBtn().addActionListener(moveProductEventListener);
            gameCardView.getStartGameBtn().setActionCommand(gameName);
            gameCardView.getStartGameBtn().addActionListener(new StartGameEventListener());
            gameCardView.getRemoveBtn().addActionListener(new RemoveCardEventListener());
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(gameCardView);
        }
        if (type == CardType.CART) {
            int sum = 0;
            for (String name : model.getCurrentUser().getCartList()) {
                sum += dataBase.getGameProductByName(name).getPrice();
            }
            view.getCartField().getPriceLabel().setText(Integer.toString(sum));
        }
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    private void setPanelVisible(FieldView panel) {
        view.getCurrentPanel().setVisible(false);
        view.setCurrentPanel(panel);
        panel.setVisible(true);
    }

    private static class TextFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            ((JTextField) e.getSource()).setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (((JTextField) e.getSource()).getText().replaceAll(" ", "").isEmpty())
                ((JTextField) e.getSource()).setText(((JTextField) e.getSource()).getName());
        }
    }

    private class ClosingWindowEventListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            if (!model.getCurrentUser().getUserName().equals("default")) {
                try {
                    dataBase.updateUser(model.getCurrentUser());
                } catch (UserNotFoundException ignored) {

                }
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    private class RemoveCardEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (((MyButton) e.getSource()).getName().equals("cart")) {
                model.getCurrentUser().getCartList().remove(command);
                view.getCartField().getPriceLabel().setText("0");
                fillPanelWithGameProducts(
                        view.getCartField().getGameProductsField(),
                        model.getCurrentUser().getCartList(),
                        CardType.CART
                );
                setPanelVisible(view.getCartField());
            } else if (((MyButton) e.getSource()).getName().equals("wishlist")) {
                model.getCurrentUser().getWishList().remove(command);
                fillPanelWithGameProducts(
                        view.getWishListField().getGameProductsField(),
                        model.getCurrentUser().getWishList(),
                        CardType.WISH_LIST
                );
                setPanelVisible(view.getWishListField());
            }
        }
    }

    private class StartGameEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            view.alertUser("Игра запускается: " + command);
        }
    }

    private class MoveProductEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.getCurrentUser().getUserName().equals("default")) {
                view.alertUser("Вы не вошли!");
                return;
            }

            String command = e.getActionCommand();

            if (command.contains("cart")) {
                String gameName = command.replaceFirst("cart ", "");
                if (!model.getCurrentUser().getCartList().contains(gameName))
                    model.getCurrentUser().getCartList().add(gameName);
            } else if (command.contains("wishlist")) {
                String gameName = command.replaceFirst("wishlist ", "");
                if (!model.getCurrentUser().getWishList().contains(gameName))
                    model.getCurrentUser().getWishList().add(gameName);
            } else if (command.equals("pay")) {
                for (String gameName : model.getCurrentUser().getCartList()) {
                    if (!model.getCurrentUser().getLibraryList().contains(gameName)) {
                        model.getCurrentUser().getLibraryList().add(gameName);
                    }
                }
                model.getCurrentUser().getCartList().clear();
                view.getCartField().getPriceLabel().setText("0");
                fillPanelWithGameProducts(
                        view.getCartField().getGameProductsField(),
                        model.getCurrentUser().getCartList(),
                        CardType.CART);
                setPanelVisible(view.getCartField());
            }
        }
    }

    private class SortEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.contains("dec")) {
                if (command.contains("shop")) {
                    fillPanelWithGameProducts(
                            view.getShopField().getGameProductsField(),
                            sortDecreasingly(dataBase.getFullProductNameList()),
                            CardType.SHOP
                    );
                    setPanelVisible(view.getShopField());
                } else if (command.contains("wishlist")) {
                    fillPanelWithGameProducts(
                            view.getWishListField().getGameProductsField(),
                            sortDecreasingly(model.getCurrentUser().getWishList()),
                            CardType.WISH_LIST
                    );
                    setPanelVisible(view.getWishListField());
                }
            } else if (command.contains("inc")) {
                if (command.contains("shop")) {
                    fillPanelWithGameProducts(
                            view.getShopField().getGameProductsField(),
                            sortIncreasingly(dataBase.getFullProductNameList()),
                            CardType.SHOP
                    );
                    setPanelVisible(view.getShopField());
                } else if (command.contains("wishlist")) {
                    fillPanelWithGameProducts(
                            view.getWishListField().getGameProductsField(),
                            sortIncreasingly(model.getCurrentUser().getWishList()),
                            CardType.WISH_LIST
                    );
                    setPanelVisible(view.getWishListField());
                }
            }
        }
    }

    private class TextSearchEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.contains("priceFind")) {
                String lowStr = view.getShopField().getShopMinPriceTF().getText().replaceAll(" |(от)", "");
                String highStr = view.getShopField().getShopMaxPriceTF().getText().replaceAll(" |(до)", "");

                int lowest;
                if (lowStr.isEmpty()) lowest = 0;
                else lowest = Integer.parseInt(lowStr);
                int highest;
                if (highStr.isEmpty()) highest = Short.MAX_VALUE;
                else highest = Integer.parseInt(highStr);

                view.getShopField().getShopMinPriceTF().setText(view.getShopField().getShopMinPriceTF().getName());
                view.getShopField().getShopMaxPriceTF().setText(view.getShopField().getShopMaxPriceTF().getName());
                fillPanelWithGameProducts(
                        view.getShopField().getGameProductsField(),
                        filterGameProductListByPrice(dataBase.getFullProductNameList(), lowest, highest),
                        CardType.SHOP
                );
                setPanelVisible(view.getShopField());
            } else if (command.contains("nameFind")) {
                String filter;
                if (command.contains("shop")) {
                    filter = view.getShopField().getShopSearchTF().getText().replaceAll(" |(Поиск)", "");
                    view.getShopField().getShopSearchTF().setText("");
                    fillPanelWithGameProducts(
                            view.getShopField().getGameProductsField(),
                            filterGameProductListByName(dataBase.getFullProductNameList(), filter),
                            CardType.SHOP
                    );
                    setPanelVisible(view.getShopField());
                } else if (command.contains("library")) {
                    filter = view.getLibraryField().getLibrarySearchTF().getText().replaceAll(" |(Поиск)", "");
                    view.getLibraryField().getLibrarySearchTF().setText("");
                    fillPanelWithGameProducts(
                            view.getLibraryField().getGameProductsField(),
                            filterGameProductListByName(model.getCurrentUser().getLibraryList(), filter),
                            CardType.LIBRARY
                    );
                    setPanelVisible(view.getLibraryField());
                } else if (command.contains("wishlist")) {
                    filter = ((WishListFieldView) view.getCurrentPanel()).getWishListSearchTF().getText();
                    view.getWishListField().getWishListSearchTF().setText("");
                    fillPanelWithGameProducts(
                            view.getWishListField().getGameProductsField(),
                            filterGameProductListByName(model.getCurrentUser().getWishList(), filter),
                            CardType.WISH_LIST
                    );
                    setPanelVisible(view.getWishListField());
                }
            }
        }
    }

    private class NavigationEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Библиотека" -> {
                    fillPanelWithGameProducts(view.getLibraryField().getGameProductsField(), model.getCurrentUser().getLibraryList(), CardType.LIBRARY);
                    setPanelVisible(view.getLibraryField());
                }
                case "Магазин" -> {
                    fillPanelWithGameProducts(view.getShopField().getGameProductsField(), dataBase.getFullProductNameList(), CardType.SHOP);
                    setPanelVisible(view.getShopField());
                }
                case "Избранное" -> {
                    fillPanelWithGameProducts(view.getWishListField().getGameProductsField(), model.getCurrentUser().getWishList(), CardType.WISH_LIST);
                    setPanelVisible(view.getWishListField());
                }
                case "Корзина" -> {
                    fillPanelWithGameProducts(view.getCartField().getGameProductsField(), model.getCurrentUser().getCartList(), CardType.CART);
                    setPanelVisible(view.getCartField());
                }
                case "Войти" -> setPanelVisible(view.getLoginField());
                default -> {
                }
            }
        }
    }

    private class LoginEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            String name = view.getLoginField().getUserNameTextField().getText();
            String password = view.getLoginField().getUserPasswordTextField().getText();

            if (name.isEmpty())
                view.alertUser("Неверное значение имени!");

            if (password.isEmpty())
                view.alertUser("Неверное значение пароля!");

            if (command.equals("login")) {
                loginUser(name, password);
            } else if (command.equals("register")) {
                registerUser(name, password);
            }
        }
    }

    public static void main(String[] args) {
        GameShopView gameShopView = new GameShopView();
        GameShop gameShop = new GameShop();
        GameShopController gameShopController = new GameShopController(gameShop, gameShopView);
        gameShopController.initController();
    }
}

package database;

import model.User;
import settings.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {

    private final String usersPath = "database\\users.dat";

    private final String productMapPath = "database\\products.dat";

    private HashMap<String, GameProduct> gameProductMap;
    private HashMap<String, User> userHashMap;
    private HashMap<String, ImageIcon> iconHashMap;

    public DataBase() {
        gameProductMap = readProductHashMapFromFile();
        userHashMap = readUserHashMapFromFile();
        iconHashMap = readImageIconsFromFile();
    }

    public User getUser(String name, String password) throws UserNotFoundException {
        if (userHashMap.containsKey(name + " " + password)) {
            return userHashMap.get(name + " " + password);
        } else {
            throw new UserNotFoundException();
        }
    }

    public void updateUser(User user) throws UserNotFoundException {
        if (userHashMap.containsKey(user.getKey())) {
            userHashMap.put(user.getKey(), user);
            writeDownUserHashMapToFile(userHashMap);
        } else {
            throw new UserNotFoundException();
        }
    }
    public void addUser(User user) throws UserAlreadyExistException {
        if (!userHashMap.containsKey(user.getKey())) {
            userHashMap.put(user.getKey(), user);
            writeDownUserHashMapToFile(userHashMap);
        } else {
            throw new UserAlreadyExistException();
        }
    }

    public GameProduct getGameProductByName(String name) {
        return gameProductMap.get(name);
    }

    public ImageIcon getImageIconByName(String name) {
        return iconHashMap.get(name);
    }

    public ArrayList<String> getFullProductNameList() {
        return new ArrayList<>(gameProductMap.keySet());
    }

    public void writeDownUserHashMapToFile(HashMap<String, User> userHashMap) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(usersPath));
            out.writeObject(userHashMap);
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    // Method used to fill database files
    public void writeDownProductHashMapToDB(HashMap<String, GameProduct> productHashMap) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(productMapPath));
            out.writeObject(productHashMap);
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<String, ImageIcon> readImageIconsFromFile() {
        HashMap<String, ImageIcon> newImageIconMap = new HashMap<>();
        for (GameProduct gameProduct : gameProductMap.values()) {
            BufferedImage logoImg;
            try {
                logoImg = ImageIO.read(new File(gameProduct.getImgPath()));
                Image image = logoImg.getScaledInstance(Settings.GameCard.IMAGE_WIDTH, Settings.GameCard.IMAGE_HEIGHT, Image.SCALE_SMOOTH);
                newImageIconMap.put(gameProduct.getName(), new ImageIcon(image));
            } catch (IOException e) {
                System.err.println(e.getMessage());;
            }
        }
        HashMap<String, String> btnIcons = new HashMap<>();
        btnIcons.put("cart", "img\\cart.png");
        btnIcons.put("remove", "img\\remove.png");
        btnIcons.put("wishlist", "img\\wishList.png");
        for (String key : btnIcons.keySet()) {
            BufferedImage logoImg;
            try {
                logoImg = ImageIO.read(new File(btnIcons.get(key)));
                Image image = logoImg.getScaledInstance(Settings.GameCard.BTN_ICON_WIDTH, Settings.GameCard.BTN_ICON_HEIGHT, Image.SCALE_SMOOTH);
                newImageIconMap.put(key, new ImageIcon(image));
            } catch (IOException e) {
                System.err.println(e.getMessage());;
            }
        }

        return newImageIconMap;
    }

    public HashMap<String, User> readUserHashMapFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(usersPath));
            HashMap<String, User> userHashMap = (HashMap<String, User>) in.readObject();
            in.close();
            return userHashMap;
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public HashMap<String, GameProduct> readProductHashMapFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(productMapPath));
            HashMap<String, GameProduct> productHashMap = (HashMap<String, GameProduct>) in.readObject();
            in.close();
            return productHashMap;
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }

    // Method used to fill database files and test program
    public HashMap<String, User> retrieveUserMapFromDB() {
        HashMap<String, User> userHashMap = new HashMap<>();
        User admin = new User("admin", "admin");
        for (String gameName : retrieveGameProductMapFromDB().keySet()) {
            admin.getCartList().add(gameName);
            admin.getLibraryList().add(gameName);
            admin.getWishList().add(gameName);
        }
        userHashMap.put(admin.getKey(), admin);
        userHashMap.put("1 1", new User("1", "1"));
        userHashMap.put("2 2", new User("2", "2"));
        return userHashMap;
    }

    // Method used to fill database files and test program
    public HashMap<String, GameProduct> retrieveGameProductMapFromDB() {

        HashMap<String, GameProduct> gameProductMap = new HashMap<>();
        gameProductMap.put("The Witcher 3 - Wild Hunt", new GameProduct("The Witcher 3 - Wild Hunt", "Ты - Геральт из Ривии, наемный убийца монстров. Перед вами раздираемый войной, кишащий монстрами континент, который вы можете исследовать по своему желанию. Ваш текущий контракт? Выслеживание Цири — Дитя Пророчества, живого оружия, способного изменить облик мира.", 1199, "img\\TheWitcher3.jpg"));
        gameProductMap.put("Hollow Knight", new GameProduct("Hollow Knight", "Hollow Knight – это эпическое приключение в огромном разрушенном королевстве, полном насекомых и героев. Исследуйте извилистые пещеры, сражайтесь с порчеными тварями и заводите дружбу со странными жуками – все это в классической двухмерной ручной рисовке.", 349, "img\\HollowKnight.jpg"));
        gameProductMap.put("DOOM Eternal", new GameProduct("DOOM Eternal", "Полноценный сиквел Doom 2016 года. Армии ада вторглись на Землю. Станьте Палачом Рока и убейте демонов во всех измерениях, чтобы спасти человечество.", 1999, "img\\DoomEternal.jpg"));
        gameProductMap.put("Divinity: Original Sin 2 - Definitive Edition", new GameProduct("Divinity: Original Sin 2 - Definitive Edition", "Знаменитая ролевая игра от разработчиков Baldur's Gate 3. Соберите отряд. Освойте мощную боевую систему. Пригласите с собой до трех друзей, но помните, что только один из вас сможет стать богом.", 799, "img\\Divinity2.jpg"));
        gameProductMap.put("Frostpunk", new GameProduct("Frostpunk", "Frostpunk – первая игра в жанре \"выживание общества\". Как правитель последнего города на земле вы будете управлять его жителями и инфраструктурой. Какие решения вы примете во имя выживания? Как себя поведете в переломный момент? Кем при этом станете?", 150, "img\\Frostpunk.jpg"));
        gameProductMap.put("Stardew Valley", new GameProduct("Stardew Valley", "Вам досталась старая дедушкина ферма в долине Стардью. С горстью монет в кармане и старыми инструментами в руках вы начинаете новую жизнь. Сможете ли вы превратить пустырь в цветущий сад?", 299, "img\\StardewValley.jpg"));
        gameProductMap.put("Trraria", new GameProduct("Trraria", "Копайте, сражайтесь, исследуйте, стройте! Нет ничего невозможного в этой насыщенной событиями приключенческой игре. Также доступен комплект для четверых!", 300, "img\\Terraria.jpg"));
        gameProductMap.put("Valheim", new GameProduct("Valheim", "Игра в жанре выживание, в которой вам предстоит исследовать огромный фэнтезийный мир, пропитанный скандинавской мифологией и культурой викингов.", 435, "img\\Valheim.jpg"));
        gameProductMap.put("Dead Cells", new GameProduct("Dead Cells", "Dead Cells — это экшн-платформер в жанре Rogue-lite и Metroidvania. Вас ждет огромный, постоянно меняющийся замок... Если, конечно, вы сможете победить тех, кто встанет у вас на пути, в 2D-схватках в стиле Souls-lite. Без сохранений. Убивайте, умирайте, учитесь и пробуйте снова.", 499, "img\\DeadCells.jpg"));
        gameProductMap.put("PUBG", new GameProduct("PUBG", "Играйте В PUBG: BATTLEGROUNDS бесплатно. Высаживайтесь в стратегически важных местах, добывайте оружие и припасы и постарайтесь выжить и остаться последней командой на одном из многочисленных полей боя.", 899, "img\\PUBG.jpg"));
        gameProductMap.put("Deep Rock Galactic", new GameProduct("Deep Rock Galactic", "Deep Rock Galactic — первый научно-фантастический шутер с видом от первого лица для совместной игры, в котором вас ждут крутые космические гномы, полностью разрушаемое окружение, процедурно генерируемые системы пещер и бесконечные волны инопланетных чудовищ.", 899, "img\\DeepRockGalactic.jpg"));
        gameProductMap.put("Elden Ring", new GameProduct("Elden Ring", "НОВЫЙ ФЭНТЕЗИЙНЫЙ РОЛЕВОЙ БОЕВИК. Восстань, погасшая душа! Междуземье ждёт своего повелителя. Пусть благодать приведёт тебя к Кольцу Элден.", 3999, "img\\EldenRing.jpg"));
        gameProductMap.put("Poison Craft", new GameProduct("Poison Craft", "Potion Craft – симулятор алхимика, в котором вы физически взаимодействуете с ингредиентами и инструментами в процессе варки зелий. Придумывайте новые рецепты, привлекайте клиентов и экспериментируйте! На вас рассчитывает весь город!", 360, "img\\PoisonCraft.jpg"));

        return gameProductMap;
    }
}

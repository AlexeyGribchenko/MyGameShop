package database;

import java.io.Serializable;

public class GameProduct extends Product implements Serializable {

    public GameProduct() {
        super();
    }

    public GameProduct(String name, String description, int price, String imgPath) {
        super(name, description, price, imgPath);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImgPath() {
        return imgPath;
    }
}

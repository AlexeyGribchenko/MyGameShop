package database;

import java.io.Serializable;

public abstract class Product implements Serializable {

    String name;
    String description;
    int price;
    String imgPath;

    Product() {
        this.name = "unknown";
        this.description = "empty";
        this.price = -1;
        this.imgPath = null;
    }

    Product(String name, String description, int price, String imgPath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
    }
}

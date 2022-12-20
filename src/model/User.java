package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private final String userName;
    private final String userPassword;
    private final ArrayList<String> cartList;
    private final ArrayList<String> wishList;
    private final ArrayList<String> libraryList;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.cartList = new ArrayList<>();
        this.wishList = new ArrayList<>();
        this.libraryList = new ArrayList<>();
    }

    public ArrayList<String> getCartList() {
        return cartList;
    }

    public ArrayList<String> getLibraryList() {
        return libraryList;
    }

    public ArrayList<String> getWishList() {
        return wishList;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getKey() {
        return userName + " " + userPassword;
    }

    @Override
    public boolean equals(Object obj) {
        return this.userName.equals(((User) obj).userName) && this.userPassword.equals(((User) obj).userPassword);
    }

    @Override
    public int hashCode() {
        return userName.hashCode() + userPassword.hashCode();
    }
}

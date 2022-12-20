package model;

import java.io.Serializable;

public class GameShop implements Serializable {

    private User currentUser;

    public GameShop() {
        this.currentUser = new User("default", "default");
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

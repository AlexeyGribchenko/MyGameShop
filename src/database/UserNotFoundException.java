package database;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("Пользователь уже существует!");
    }
}
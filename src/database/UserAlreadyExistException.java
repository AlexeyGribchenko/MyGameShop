package database;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(){
        super("Пользователь уже существует!");
    }
}

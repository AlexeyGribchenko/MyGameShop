package view;

import mycomponents.MyButton;
import mycomponents.MyLabel;
import mycomponents.MyTextField;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class LoginFieldView extends FieldView {

    private final MyButton loginBtn;
    private final MyButton registerBtn;
    private final MyTextField userNameTextField;
    private final MyTextField userPasswordTextField;
    public LoginFieldView() {

        super(new JPanel());
        setBackground(Color.decode(Settings.Color.DARK_BLUE));

        loginBtn = new MyButton("Вход");
        registerBtn = new MyButton("Регистрация");
        userNameTextField = new MyTextField();
        userNameTextField.setName("  ");
        userPasswordTextField = new MyTextField();
        userPasswordTextField.setName("  ");
        MyLabel userNameLabel = new MyLabel("Логин");
        MyLabel userPasswordLabel = new MyLabel("Пароль");

        GroupLayout loginGL = new GroupLayout(this);
        setLayout(loginGL);

        loginGL.setHorizontalGroup(
                loginGL.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(
                                loginGL.createParallelGroup()
                                        .addComponent(userNameLabel)
                                        .addComponent(userNameTextField, 0, GroupLayout.DEFAULT_SIZE, 350)
                                        .addComponent(userPasswordLabel)
                                        .addComponent(userPasswordTextField, 0, GroupLayout.DEFAULT_SIZE, 350)
                                        .addGroup(
                                                loginGL.createSequentialGroup()
                                                        .addComponent(loginBtn, 0 ,GroupLayout.DEFAULT_SIZE, 150)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, 50)
                                                        .addComponent(registerBtn, 0 ,GroupLayout.DEFAULT_SIZE, 150)
                                        )
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginGL.setVerticalGroup(
                loginGL.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userNameLabel, 0, 35, 35)
                        .addComponent(userNameTextField, 0, GroupLayout.DEFAULT_SIZE, 35)
                        .addComponent(userPasswordLabel, 0, 35, 35)
                        .addComponent(userPasswordTextField, 0, GroupLayout.DEFAULT_SIZE, 35)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, 20)
                        .addGroup(
                                loginGL.createParallelGroup()
                                        .addComponent(loginBtn,0, 35, 35)
                                        .addComponent(registerBtn, 0, 35, 35)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    @Override
    public JPanel getGameProductsField() {
        return null;
    }

    public MyButton getLoginBtn() {
        return loginBtn;
    }

    public MyButton getRegisterBtn() {
        return registerBtn;
    }

    public MyTextField getUserNameTextField() {
        return userNameTextField;
    }

    public MyTextField getUserPasswordTextField() {
        return userPasswordTextField;
    }
}

package mycomponents;

import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class MyTextArea extends JTextArea {
    public MyTextArea() {
        super();
        setFont(new Font("Arial", Font.PLAIN, 14));
        setForeground(Color.decode(Settings.Color.TEXT_CODE));
        setBackground(Color.decode(Settings.Color.DARK_BLUE));
    }

    public MyTextArea(String text) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 14));
        setForeground(Color.decode(Settings.Color.TEXT_CODE));
        setBackground(Color.decode(Settings.Color.DARK_BLUE));
    }
}

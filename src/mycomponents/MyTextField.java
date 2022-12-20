package mycomponents;

import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField{
    public MyTextField() {
        super();
        setFont(new Font("Arial", Font.PLAIN, 12));
        setForeground(Color.decode(Settings.Color.TEXT_CODE));
        setBackground(Color.decode(Settings.Color.BLUE));
        setBorder(BorderFactory.createEmptyBorder());
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(0, 5, 0, 0)
        ));
    }

    public MyTextField(String text) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 12));
        setForeground(Color.decode(Settings.Color.TEXT_CODE));
        setBackground(Color.decode(Settings.Color.BLUE));
        setBorder(BorderFactory.createEmptyBorder());
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(0, 5, 0, 0)
        ));
    }
}
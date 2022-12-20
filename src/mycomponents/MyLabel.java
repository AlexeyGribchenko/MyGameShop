package mycomponents;

import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel() {
        super();
        setForeground(Color.decode(Settings.Color.TEXT_CODE));
        setFont(new Font("Arial", Font.BOLD, 15));
    }

    public MyLabel(String text) {
        super(text);
        setForeground(Color.decode(Settings.Color.TEXT_CODE));
        setFont(new Font("Arial", Font.BOLD, 15));
    }

    public MyLabel(ImageIcon icon) {
        super(icon);
    }
}

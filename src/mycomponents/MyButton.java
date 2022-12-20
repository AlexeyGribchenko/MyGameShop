package mycomponents;

import settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButton extends JButton {

    public MyButton() {
        super();
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(Color.decode(Settings.Color.DARK_GREEN));
        setBorder(BorderFactory.createEmptyBorder());
        setForeground(Color.decode(Settings.Color.GREEN));
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#659229"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode(Settings.Color.DARK_GREEN));
            }
        });
    }

    public MyButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(Color.decode(Settings.Color.DARK_GREEN));
        setBorder(BorderFactory.createEmptyBorder());
        setForeground(Color.decode(Settings.Color.GREEN));
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.decode("#659229"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.decode(Settings.Color.DARK_GREEN));
            }
        });
    }
}

package view;

import javax.swing.*;

public abstract class FieldView extends JPanel {

    protected final JPanel gameProductsField;

    protected FieldView(JPanel gameProductsField) {
        this.gameProductsField = gameProductsField;
    }

    public JPanel getGameProductsField() {
        return gameProductsField;
    }
}

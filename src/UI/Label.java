package UI;

import javax.swing.*;
import java.awt.*;

abstract public class Label extends JLabel {
    protected String suffix;

    public Label(String suffix, int size) {
        super(suffix);
        this.suffix = suffix;
        Font font = new Font("Jokerman", Font.PLAIN, size);
        setFont(font);
    }
}

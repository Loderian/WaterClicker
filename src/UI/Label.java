package UI;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    private static String fontName = null;
    private int fontSize;

    public Label(int fontSize) {
        super("");
        setFont(makeFont(fontSize));
    }

    public Label(String text, int fontSize) {
        super(text);
        setFont(makeFont(fontSize));
    }

    private Font makeFont(int fontSize) {
        if (fontName == null) {
            loadFont();
        }
        return new Font(fontName, Font.PLAIN, fontSize);
    }

    public static void loadFont() {
        fontName = "Courier";
    }
}

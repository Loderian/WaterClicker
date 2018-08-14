package UI;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameText extends Text {
    private String fontName = null;
    private int fontSize;

    public GameText(int fontSize) {
        super("");
        this.fontSize = fontSize;
        setFont(makeFont());
    }

    public GameText(String text, int fontSize) {
        super(text);
        this.fontSize = fontSize;
        setFont(makeFont());
    }

    public GameText(String text, String fontName, int fontSize) {
        super(text);
        this.fontName = fontName;
        this.fontSize = fontSize;
        setFont(makeFont());
    }

    private Font makeFont() {
        if (fontName == null) {
            loadFont();
        }
        return new Font(fontName, fontSize);
    }

    public void loadFont() {
        fontName = "Courier";
    }


    public static String formatDouble(double d) {
        if (d >= 1000000.0) {
            int exp = (int) Math.log10(d);
            double digit = d / Math.pow(10, exp);
            return String.format("%.3fe+%d", digit, exp);
        }
        else {
            return String.format("%.3f", d);
        }
    }
}

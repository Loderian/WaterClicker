package UI;

import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class GameText extends Text {
    private static String fontName = null;
    private int fontSize;

    public GameText(int fontSize) {
        super("");
        setFont(makeFont(fontSize));
    }

    public GameText(String text, int fontSize) {
        super(text);
        setFont(makeFont(fontSize));
    }

    private Font makeFont(int fontSize) {
        if (fontName == null) {
            loadFont();
        }
        return new Font(fontName, fontSize);
    }

    public static void loadFont() {
        fontName = "Courier";
    }
}

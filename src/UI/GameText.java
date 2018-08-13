package UI;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameText extends Text {
    private String fontName = null;
    private int fontSize;

    public GameText(int fontSize) {
        super("");
        setFont(makeFont(fontSize));
    }

    public GameText(String text, int fontSize) {
        super(text);
        setFont(makeFont(fontSize));
    }

    public GameText(String text, String fontName, int fontSize) {
        super(text);
        this.fontName = fontName;
        this.fontSize = fontSize;
    }

    private Font makeFont(int fontSize) {
        if (fontName == null) {
            loadFont();
        }
        return new Font(fontName, fontSize);
    }

    public void loadFont() {
        fontName = "Courier";
    }
}

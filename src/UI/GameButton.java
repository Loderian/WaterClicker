package UI;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.util.Builder;

import java.util.function.Function;

public class GameButton extends GameText implements Builder<HBox> {
    protected Function<String, Void> func;
    protected String event;

    public GameButton(String display, int fontSize, Function<String, Void> func) {
        super(display, fontSize);
        this.func = func;
        this.event = display;
    }

    public GameButton(String display, String event, int fontSize, Function<String, Void> func) {
        super(display, fontSize);
        this.func = func;
        this.event = event;
    }

    @Override
    public HBox build() {
        HBox button = new HBox(this);
        this.setFill(Paint.valueOf("white"));
        button.setOnMouseClicked(e -> func.apply(this.event));
        button.getStyleClass().add("button");
        button.setPadding(new Insets(0, 5, 0, 0));
        return button;
    }
}

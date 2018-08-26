package UI;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.util.Builder;

import java.util.function.Function;

public class GameButton implements Builder<HBox> {
    protected GameText buttonText;
    protected Function<String, Void> func;
    protected String event;

    public GameButton(String display, int fontSize, Function<String, Void> func) {
        buttonText = new GameText(display, fontSize);
        this.func = func;
        this.event = display;
    }

    public GameButton(String display, String event, int fontSize, Function<String, Void> func) {
        buttonText = new GameText(display, fontSize);
        this.func = func;
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void doAction() {
        func.apply(event);
    }

    public void activate() {
        buttonText.setFill(Paint.valueOf("white"));
    }

    public void deactivate() {
        buttonText.setFill(Paint.valueOf("grey"));
    }

    @Override
    public HBox build() {
        HBox button = new HBox(buttonText);
        buttonText.setFill(Paint.valueOf("white"));
        button.setOnMouseClicked(e -> func.apply(this.event));
        button.getStyleClass().add("button");
        button.setPadding(new Insets(5, 7, 5, 7));
        HBox.setMargin(button, new Insets(0, 5, 0, 0));
        return button;
    }
}

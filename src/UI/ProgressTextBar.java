package UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class ProgressTextBar implements Builder<HBox> {
    protected ProgressBar bar;
    protected GameText barText;
    protected double width;

    public ProgressTextBar(String barText, int fontsize, double width) {
        this.barText = new GameText(barText, fontsize);
        this.width = width;
        this.bar = new ProgressBar();

        bar.setProgress(0);

    }

    public void update(String text, double progress) {
        barText.setText(text);
        bar.setProgress(progress);
    }

    @Override
    public HBox build() {
        bar.setMaxWidth(width);
        bar.setPrefWidth(width);
        bar.setMinWidth(width);
        bar.getStyleClass().add("progress-bar");
        StackPane barStack = new StackPane(bar, barText);
        barStack.setAlignment(Pos.CENTER);
        HBox container = new HBox(barStack);

        return container;
    }
}

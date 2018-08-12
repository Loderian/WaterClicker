package UI;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Builder;

public class BuildingDetails implements Builder<HBox>{
    protected GameText name;
    protected GameText description;
    protected GameText stats;

    public BuildingDetails(String name, String description, String stats) {
        this.name = new GameText(name, 18);
        this.description = new GameText(description, 14);
        this.stats = new GameText(stats, 14);
    }

    public void update(String stats) {
        this.stats.setText(stats);
    }

    @Override
    public HBox build() {
        VBox box = new VBox(name, description, stats);
        box.setPadding(new Insets(5, 10, 5, 10));
        box.setPrefWidth(300);
        box.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(3), Insets.EMPTY)));

        HBox right = new HBox(box);
        HBox.setHgrow(right, Priority.ALWAYS);
        right.setAlignment(Pos.BASELINE_RIGHT);
        right.toFront();
        right.setVisible(false);

        return right;
    }
}

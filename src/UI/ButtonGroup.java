package UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ButtonGroup implements Builder<HBox> {
    protected String state = null;
    protected List<GameButton> buttons;

    public ButtonGroup(GameButton... buttons) {
        this.buttons = new ArrayList<>();
        for (GameButton button : buttons) {
            this.buttons.add(button);
        }
    }

    public ButtonGroup(List<GameButton> buttons) {
        this.buttons = buttons;
    }

    public void add(GameButton button) {
        buttons.add(button);
    }

    public void loadState() {
        if (buttons.size() > 0) {
            this.state = buttons.get(0).getEvent();
        }
    }

    public void activate(String buttonEvent) {
        for (GameButton gb : buttons) {
            if (buttonEvent.equals(gb.getEvent())) {
                gb.activate();
            }
            else {
                gb.deactivate();
            }
        }
    }

    @Override
    public HBox build() {
        HBox group = new HBox();
        group.setAlignment(Pos.BASELINE_CENTER);
        group.setPadding(new Insets(10, 0, 10, 0));
        for (GameButton button : buttons) {
            HBox box = button.build();
            box.setOnMouseClicked(e -> {
                activate(button.getEvent());
                button.doAction();
            });
            group.getChildren().add(box);
        }
        loadState();
        activate(state);

        return group;
    }
}

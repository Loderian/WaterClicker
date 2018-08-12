package UI;

import Core.Game;
import GameObjects.Producer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class BuildingDisplay extends ImageDisplay implements Comparable<BuildingDisplay> {
    protected GameText name;
    protected GameText owned;
    protected GameText cost;
    protected BuildingDetails details;

    protected Producer producer;

    public BuildingDisplay(Producer p, String imagePath) {
        super(50, 50, imagePath);
        this.producer = p;
        this.name = new GameText(producer.getName(), 20);
        this.cost = new GameText("" + producer.getCost(), 20);
        this.owned = new GameText("" + producer.getOwned(), 50);
        this.details = new BuildingDetails(producer.getName(), "Desc", getStats());
    }

    public void updateCost() {
        this.cost.setText("" + producer.getCost());
    }

    public void updateOwned() {
        this.owned.setText("" + producer.getOwned());
    }

    public HBox buildHover() {
        return details.build();
    }

    public String getStats() {
        String str = "Produces: " + producer.getProduction() + producer.getProduct().toString() + " per second.\n";
        str += "Total production: " + producer.getTotalProduction();
        return str;
    }

    @Override
    public Node build() {
        VBox nameBox = new VBox(name, cost);
        nameBox.setAlignment(Pos.TOP_LEFT);
        HBox.setHgrow(nameBox, Priority.ALWAYS);

        HBox box = new HBox(10, super.build(), nameBox, owned);
        box.setPadding(new Insets(5, 10, 5, 10));
        box.setOnMouseClicked(event -> producer.buy());

        return box;
    }

    @Override
    public int compareTo(BuildingDisplay o) {
        return this.producer.getPos() - o.producer.getPos();
    }

    public static void addHover(Node buildingBox, HBox hoverBox) {
        buildingBox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!hoverBox.isVisible()) {
                    hoverBox.setVisible(true);
                }
            }
        });
        buildingBox.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (hoverBox.isVisible()) {
                    hoverBox.setTranslateY(event.getY());
                }
            }
        });
        buildingBox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (hoverBox.isVisible()) {
                    hoverBox.setVisible(false);
                }
            }
        });
    }
}

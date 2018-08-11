package UI;

import Core.Game;
import GameObjects.Producer;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class BuildingDisplay extends ImageDisplay {
    protected GameText name;
    protected GameText owned;
    protected GameText cost;
    protected Producer producer;

    public BuildingDisplay(String name, String imagePath) {
        super(50, 50, imagePath);
        this.producer = Game.getProducer(name);
        this.name = new GameText(producer.getName(), 14);
        this.cost = new GameText("" + producer.getCost(), 14);
        this.owned = new GameText("" + producer.getOwned(), 35);
    }

    public void updateCost() {
        this.cost.setText("" + producer.getCost());
    }

    public void updateOwned() {
        this.owned.setText("" + producer.getOwned());
    }

    @Override
    public Node build() {
        VBox nameBox = new VBox(name, cost);

        HBox box = new HBox(super.build(), nameBox, owned);
        box.setSpacing(10);
        box.setOnMouseClicked(event -> producer.buy());

        return box;
    }
}

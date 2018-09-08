package UI;

import GameObjects.Collector;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CollectorDisplay extends ProducerDisplay {
    protected ProgressTextBar progressbar;

    public CollectorDisplay(Collector p, String imageName) {
        super(p, imageName);
        progressbar = new ProgressTextBar(p.printBank(), 10, 150);
    }

    @Override
    public void update() {
        if (producer.getOwned() <= 0) {
            return;
        }
        super.update();
        double progress = ((Collector) producer).getBank() / ((Collector) producer).getCapacity();
        progressbar.update(((Collector) producer).printBank(), progress);
    }

    @Override
    public Node build() {
        VBox nameBox = buildNameBox();
        nameBox.getChildren().add(new HBox(progressbar.build()));

        return buildMainBox(nameBox);
    }
}

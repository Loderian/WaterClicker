package UI;

import GameObjects.Producer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class ProducerDisplay extends ImageDisplay {
    protected GameText name;
    protected GameText owned;
    protected GameText cost;
    protected ProducerDetails details;

    protected Producer producer;

    public ProducerDisplay(Producer p, String imageName) {
        super(50, 50, imageName);
        this.producer = p;
        this.name = new GameText(producer.getName(), 14);
        this.cost = new GameText("" + producer.getCost(), 14);
        this.owned = new GameText("" + producer.getOwned(), 50);
        this.details = new ProducerDetails(producer.getName(), "Desc", getStats());
    }

    public void update() {
        this.cost.setText("" + GameText.formatDouble(producer.getCost()));
        this.owned.setText("" + producer.getOwned());
        this.details.update(getStats());
    }

    public HBox buildHover() {
        return details.build();
    }

    public String getStats() {
        String str = producer.printProduction();
        str += producer.printTotalProduction();
        return str;
    }

    @Override
    public Node build() {
        ImageDisplay costImg = new ImageDisplay(14, 14, producer.getCostType().toString());
        HBox costBox = new HBox(cost, costImg.build());
        VBox nameBox = new VBox(name, costBox);
        nameBox.setAlignment(Pos.TOP_LEFT);
        HBox.setHgrow(nameBox, Priority.ALWAYS);

        HBox box = new HBox(10, super.build(), nameBox, owned);
        box.setPadding(new Insets(5, 10, 5, 10));
        box.setOnMouseClicked(event -> producer.buy());

        return box;
    }

    public static void addHover(Node buildingBox, HBox hoverBox) {
        buildingBox.setOnMouseEntered(event -> {
            if (!hoverBox.isVisible()) {
                hoverBox.setVisible(true);
            }
        });
        buildingBox.setOnMouseMoved(event -> {
            if (hoverBox.isVisible()) {
                hoverBox.setTranslateY(event.getY());
            }
        });
        buildingBox.setOnMouseExited(event -> {
            if (hoverBox.isVisible()) {
                hoverBox.setVisible(false);
            }
        });
    }
}

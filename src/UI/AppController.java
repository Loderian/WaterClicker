package UI;

import GameObjects.Type;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    @FXML
    private GridPane mainGrid;

    private List<CurrencyDisplay> currencies;
    private List<BuildingDisplay> buildings;


    public void init() {
        CurrencyDisplay waterDisplay = new CurrencyDisplay("assets/water.jpg", Type.WATER);
        currencies = new ArrayList<>();
        currencies.add(waterDisplay);

        mainGrid.add(waterDisplay.build(), 0, 0);

        BuildingDisplay buildingDisplay = new BuildingDisplay("Bucket", "assets/bucket.png");
        this.buildings = new ArrayList<>();
        this.buildings.add(buildingDisplay);

        VBox buildings = new VBox();
        buildings.getChildren().add(buildingDisplay.build());

        mainGrid.add(buildings, 1, 0);
    }

    public void update() {
        for (CurrencyDisplay c : currencies) {
            c.updateBank();
            c.updateProduction();
        }
        for (BuildingDisplay b : buildings) {
            b.updateCost();
            b.updateOwned();
        }
    }
}

package UI;

import Core.Game;
import GameObjects.Producer;
import GameObjects.Type;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppController {
    @FXML
    private GridPane mainGrid;

    @FXML
    private VBox currencyBox;

    @FXML
    private VBox middleBox;

    @FXML
    private VBox buildingsBox;

    private List<CurrencyDisplay> currencies;
    private List<BuildingDisplay> buildings;


    public void init(Stage window) {
        currencyBox.prefHeightProperty().bind(window.widthProperty());
        currencyBox.setMinWidth(300);
        middleBox.prefHeightProperty().bind(window.widthProperty());
        buildingsBox.prefHeightProperty().bind(window.widthProperty());
        buildingsBox.setMinWidth(300);

        CurrencyDisplay waterDisplay = new CurrencyDisplay("assets/water.jpg", Type.WATER);
        currencies = new ArrayList<>();
        currencies.add(waterDisplay);

        Collections.sort(currencies);

        for(CurrencyDisplay cd : currencies) {
            currencyBox.getChildren().add(cd.build());
        }

        currencyBox.getChildren().add(waterDisplay.build());

        this.buildings = new ArrayList<>();
        for(Producer p : Game.getProducers()) {
            this.buildings.add(new BuildingDisplay(p, ImageDisplay.getImagePath(p.getName())));
        }
        Collections.sort(buildings);

        for(BuildingDisplay bd : buildings) {
            buildingsBox.getChildren().add(bd.build());
        }

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

package UI;

import Core.Game;
import GameObjects.Producer;
import GameObjects.Type;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
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
    private VBox hoverBox;

    @FXML
    private Text gameStats;

    @FXML
    private VBox buildingsBox;

    @FXML
    private HBox buildingMenu;

    private List<CurrencyDisplay> currencies;
    private List<BuildingDisplay> buildings;

    public void init(Stage primaryStage) {
        currencyBox.prefHeightProperty().bind(primaryStage.widthProperty());
        currencyBox.setMinWidth(300);
        middleBox.prefHeightProperty().bind(primaryStage.widthProperty());
        middleBox.setPadding(new Insets(5, 0, 5, 10));
        buildingsBox.prefHeightProperty().bind(primaryStage.widthProperty());
        buildingsBox.setMinWidth(300);

        hoverBox.setMaxWidth(400);

        buildingMenu.setMinHeight(30);

        CurrencyDisplay waterDisplay = new CurrencyDisplay("assets/water.png", Type.WATER);
        currencies = new ArrayList<>();
        currencies.add(waterDisplay);

        Collections.sort(currencies);

        for(CurrencyDisplay cd : currencies) {
            currencyBox.getChildren().add(cd.build());
        }

        currencyBox.getChildren().add(waterDisplay.build());

        buildings = new ArrayList<>();
        for(Producer p : Game.getProducers()) {
            buildings.add(new BuildingDisplay(p, ImageDisplay.getImagePath(p.getName())));
        }

        Collections.sort(buildings);

        for(BuildingDisplay bd : buildings) {
            HBox buildingBox = (HBox) bd.build();
            HBox hoverBox = bd.buildHover();
            buildingBox.setMaxWidth(300);
            buildingBox.setMinWidth(300);

            buildingsBox.getChildren().add(buildingBox);
            this.hoverBox.getChildren().add(hoverBox);

            BuildingDisplay.addHover(buildingBox, hoverBox);
        }

    }

    public void update() {
        for (CurrencyDisplay c : currencies) {
            c.update();
        }
        for (BuildingDisplay b : buildings) {
            b.update();
        }
        gameStats.setText(Game.getStats().toString());
    }
}

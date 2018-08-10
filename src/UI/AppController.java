package UI;

import Core.Game;
import GameObjects.Clickable;
import GameObjects.Type;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AppController {
    @FXML
    private Text waterBank;

    @FXML
    private Text waterProd;

    @FXML
    private ImageView waterImage;

    @FXML
    private ImageView waterDistillerImage;

    @FXML
    private Text wdCost;

    @FXML
    private Text wdAmount;


    public void init() {
        waterImage.setOnMouseClicked(event -> ((Clickable) Game.getCurrency(Type.WATER)).click());
        waterDistillerImage.setOnMouseClicked(event -> (Game.getProducer("wd")).buy());
    }

    @FXML
    public void updateWater() {
        waterBank.setText(Game.getCurrency(Type.WATER).printAmount());
        Game.getCurrency(Type.WATER).calcProduction();
        waterProd.setText(Game.getCurrency(Type.WATER).printProd());
    }

    @FXML
    public void updateWaterDistiller() {
        wdCost.setText(String.format("Cost: %.3f", Game.getProducer("wd").getCost()));
        wdAmount.setText(String.format("%d", Game.getProducer("wd").getOwned()));
    }
}

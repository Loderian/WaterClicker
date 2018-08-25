package UI;

import Core.Game;
import GameObjects.Clickable;
import GameObjects.Currency;
import GameObjects.Type;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;


public class CurrencyDisplay extends ImageDisplay {
    protected GameText bank;
    protected GameText production;
    protected GameText rate;
    protected Type type;
    protected Currency currency;

    public CurrencyDisplay(Type type, String imageName) {
        super(150, 150, imageName);
        this.type = type;
        this.bank = new GameText(28);
        this.production = new GameText(18);
        this.rate = new GameText(14);
        this.currency = Game.getCurrency(type);

        if (this.currency instanceof Clickable) {
            image.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    ((Clickable) this.currency).leftClick();
                }
                if (event.getButton() == MouseButton.SECONDARY) {
                    ((Clickable) this.currency).rightClick();
                }
            });
        }
    }

    public void update() {
        this.bank.setText(currency.printBank());
        this.production.setText(currency.printProd());
        this.rate.setText(currency.printRate());
    }

    @Override
    public VBox build() {
        VBox box = new VBox(bank, production, super.build(), rate);
        box.setAlignment(Pos.CENTER);

        return box;
    }
}

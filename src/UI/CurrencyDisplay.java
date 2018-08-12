package UI;

import Core.Game;
import GameObjects.Clickable;
import GameObjects.Currency;
import GameObjects.Type;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Builder;


public class CurrencyDisplay extends ImageDisplay implements Comparable<CurrencyDisplay> {
    protected GameText bank;
    protected GameText production;
    protected Type type;
    protected Currency currency;

    public CurrencyDisplay(String imagePath, Type type) {
        super("waterImg", 150, 150, imagePath);
        this.type = type;
        this.bank = new GameText(35);
        this.production = new GameText(24);
        this.currency = Game.getCurrency(type);

        if (this.currency instanceof Clickable) {
            image.setOnMouseClicked(event -> ((Clickable) this.currency).click());
        }
    }

    public void update() {
        this.bank.setText(currency.printAmount());
        this.production.setText(currency.printProd());
    }

    @Override
    public VBox build() {
        VBox box = new VBox(bank, production, super.build());
        box.setAlignment(Pos.CENTER);

        return box;
    }

    @Override
    public int compareTo(CurrencyDisplay o) {
        return this.currency.getPos() - o.currency.getPos();
    }
}

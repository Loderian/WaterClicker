package GameObjects;

import Core.Game;
import UI.GameText;

public class Water extends Currency implements Clickable {
    public Water() {
        super(0, Type.WATER);
    }

    public void sell(double amount) {
        if (canUse(amount)) {
            Game.getCurrency(Type.MONEY).add(Currency.getRate(type) * amount);
            sub(amount);
        }
    }

    @Override
    public void leftClick() {
        add(0.1);
    }

    @Override
    public void rightClick() {
        sell(bank * transaction);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void fixedUpdate() {

    }

    @Override
    public String printRate() {
        return String.format("1.0 %s is worth %s %s", getMidfix(), GameText.formatDouble(getRate(this.type)), Game.getCurrency(Type.MONEY).getType());
    }
}

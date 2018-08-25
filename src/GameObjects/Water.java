package GameObjects;

import Core.Game;

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
        sell(1.0);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void fixedUpdate() {

    }
}

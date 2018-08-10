package GameObjects;

import Core.Game;

public class WaterDistiller extends Producer {
    public WaterDistiller() {
        super(0.001, 1, 0, Type.WATER, Type.WATER);
    }

    @Override
    public void update() {

    }

    @Override
    public void fixedUpdate() {
        Game.getCurrency(product).add(getProduction()/50);
    }

    @Override
    public void click() {
        buy();
    }
}

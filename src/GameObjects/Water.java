package GameObjects;

import UI.Window;

public class Water extends Currency {
    public Water() {
        super(0, Type.WATER);
    }

    @Override
    public void click() {
        add(0.001);
    }

    @Override
    public void update() {
        Window.updateWater(amount);
    }

    @Override
    public void fixedUpdate() {

    }
}

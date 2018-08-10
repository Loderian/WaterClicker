package GameObjects;

import UI.Window;

public class Water extends Currency implements Clickable {
    public Water() {
        super(0, Type.WATER);
    }

    @Override
    public void click() {
        add(0.001);
    }

    @Override
    public void update() {
        Window.updateWater();
    }

    @Override
    public void fixedUpdate() {

    }
}

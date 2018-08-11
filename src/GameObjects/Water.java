package GameObjects;

import UI.Window;

public class Water extends Currency implements Clickable {
    public Water() {
        super(0, Type.WATER);
    }

    @Override
    public void click() {
        add(0.1);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void fixedUpdate() {

    }
}

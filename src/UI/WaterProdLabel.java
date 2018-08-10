package UI;

import Core.Game;
import GameObjects.Producer;

import java.util.Collection;

public class WaterProdLabel extends Label {
    public WaterProdLabel() {
        super("l", 24);

        update();
    }

    public void update() {
        Collection<Producer> producers = Game.getProducers();
        double prod = 0.0;
        for(Producer p : producers) {
            prod += p.getProduction();
        }
        setText(String.format("per second %.3f %s", prod, suffix));
    }
}

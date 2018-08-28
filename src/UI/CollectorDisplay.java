package UI;

import GameObjects.Collector;
import GameObjects.Producer;

public class CollectorDisplay extends ProducerDisplay {
    protected GameText bank;

    public CollectorDisplay(Collector p, String imageName) {
        super(p, imageName);
        bank = new GameText(p.printBank(),14);
    }

    @Override
    public void update() {
        super.update();
        bank.setText(((Collector) producer).printBank());
    }
}

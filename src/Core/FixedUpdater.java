package Core;

import GameObjects.GameObject;
import java.util.Collection;
import java.util.TimerTask;

public class FixedUpdater extends TimerTask {
    private Collection<GameObject> objects;
    private final int millis;
    private int updates;

    public FixedUpdater(Collection<GameObject> objects, final int millis) {
        this.objects = objects;
        this.millis = millis;
        this.updates = 0;
    }

    @Override
    public void run() {
        for (GameObject obj : objects) {
            obj.fixedUpdate();
        }
        updates++;
        if (updates * millis == 1000) {
            Game.getStats().updateTime();
            updates = 0;
        }
    }

    public int getMillis() {
        return millis;
    }
}

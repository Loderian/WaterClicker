package Core;

import GameObjects.GameObject;
import java.util.Collection;
import java.util.TimerTask;

public class FixedUpdater extends TimerTask {
    Collection<GameObject> objects;

    public FixedUpdater(Collection<GameObject> objects) {
        this.objects = objects;
    }

    @Override
    public void run() {
        for (GameObject obj : objects) {
            obj.fixedUpdate();
        }
    }
}

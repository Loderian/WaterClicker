package Core;

import GameObjects.*;

import java.util.Collection;
import java.util.Timer;

public class Controller implements Runnable{
    volatile static boolean run;
    Collection<GameObject> objects;

    public Controller(Collection<GameObject> objects) {
        this.objects = objects;
        run = true;
    }

    public void start() {
        try {
            this.update();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update() throws InterruptedException {
        while(true) {
            for (GameObject obj : objects) {
                obj.update();
            }
            if (!run) {
                break;
            }
        }
    }

    static void stop() {
        run = false;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new FixedUpdater(objects), 0, 50);
    }
}

package Core;

import GameObjects.*;
import UI.AppController;
import javafx.animation.AnimationTimer;

import java.util.Collection;


public class Updater extends AnimationTimer {
    AppController ui;
    Collection<GameObject> objects;

    public Updater(Collection<GameObject> objects) {
        this.objects = objects;
    }

    @Override
    public void handle(long now) {
        for (GameObject obj : objects) {
            obj.update();
            ui.updateWater();
            ui.updateWaterDistiller();
        }
    }

    public void setUI(AppController ui) {
        this.ui = ui;
    }
}

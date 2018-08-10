package Core;

import GameObjects.*;
import UI.Window;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Game {
    static Controller controller = null;
    static Window gameWindow;
    static HashMap<String, Producer> producers = new HashMap<>();
    static HashMap<Type, Currency> currencies = new HashMap<>();
    volatile static boolean ready = false;

    public static void main(String[] args) {
        controller = null;
        System.out.println("Game Start");

        javax.swing.SwingUtilities.invokeLater(() -> {
            gameWindow = new Window();
            ready = gameWindow.showNewWindow();
        });

        currencies.put(Type.WATER, new Water());
        producers.put("wd", new WaterDistiller());

        ArrayList<GameObject> allObjects = new ArrayList<>();
        allObjects.addAll(currencies.values());
        allObjects.addAll(producers.values());

        while(!ready) {} //Wait for window

        controller = new Controller(allObjects);
        Thread fixedUpdater = new Thread(controller);
        fixedUpdater.start();
        controller.start();
    }

    public static void exit() {
        if (controller != null) {
            Controller.stop();
        }
        for (GameObject obj : producers.values()) {
            System.out.println(obj.toString());
        }
        for (GameObject obj : currencies.values()) {
            System.out.println(obj.toString());
        }
        System.out.println("Game Over");
        System.exit(0);
    }

    public static GameObject getProducer(String key) {
        return producers.get(key);
    }

    public static Currency getCurrency(Type key) {
        return currencies.get(key);
    }

    public static Collection<Producer> getProducers() {
        return producers.values();
    }

    public static Collection<Currency> getCurrencies() {
        return currencies.values();
    }
}

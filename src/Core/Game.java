package Core;

import GameObjects.*;
import UI.AppController;
import UI.Window;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Timer;

public class Game extends Application {
    volatile static Updater controller;
    volatile static FixedUpdater fixedUpdater;
    volatile static Window gameWindow;
    volatile static AppController ui;
    volatile static HashMap<String, Producer> producers = new HashMap<>();
    volatile static HashMap<Type, Currency> currencies = new HashMap<>();
    volatile static boolean ready;

    public static void main(String[] args) {
        ready = false;
        controller = null;

        currencies.put(Type.WATER, new Water());

        producers.put("Bucket", new Producer("Bucket", 0, 0.1, 1.0, 0, Type.WATER, Type.WATER));
        producers.put("Water Distiller", new Producer("Water Distiller", 1, 5, 20, 0, Type.WATER, Type.WATER));


        ArrayList<GameObject> allObjects = new ArrayList<>();
        allObjects.addAll(currencies.values());
        allObjects.addAll(producers.values());
        controller = new Updater(allObjects);
        fixedUpdater = new FixedUpdater(allObjects);

        launch(args);

        exit();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/fxml/main.fxml"));
            Parent root = loader.load();
            ui = loader.getController();
            ui.init(primaryStage);
            controller.setUI(ui);

            primaryStage.setTitle("Water Clicker");
            primaryStage.setScene(new Scene(root, 1280, 720));
            gameWindow = new Window(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
            exit();
        }

        System.out.println("Game Start");

        controller.start();
        Thread fixedThread = new Thread(() -> {
            Timer timer = new Timer();
            timer.schedule(fixedUpdater, 0, 20);
        });
        fixedThread.start();

    }

    public static void exit() {
        if (controller != null) {
            controller.stop();
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

    public static Producer getProducer(String key) {
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

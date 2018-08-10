package UI;

import Core.Game;
import GameObjects.Producer;
import GameObjects.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Window  {
    Stage stage;

    public Window(Stage stage) {
        this.stage = stage;
        stage.show();
    }
}

package UI;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import javafx.util.Builder;

public class ImageDisplay implements Builder<Node> {
    protected ImageView image;

    public ImageDisplay(double w, double h, String imagePath) {
        Image image = new Image(imagePath);
        this.image = new ImageView(image);
        this.image.setPreserveRatio(true);
        this.image.setFitWidth(w);
        this.image.setFitHeight(h);
    }

    public ImageDisplay(String id, double w, double h, String imagePath) {
        Image image = new Image(imagePath);
        this.image = new ImageView(image);
        this.image.setPreserveRatio(true);
        this.image.setFitWidth(w);
        this.image.setFitHeight(h);
        this.image.setId(id);
    }

    @Override
    public Node build() {
        return this.image;
    }

    static String getImagePath(String name) {
        return "assets/" + name + ".png";
    }
}

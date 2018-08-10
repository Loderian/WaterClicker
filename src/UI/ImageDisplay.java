package UI;

import javax.swing.*;
import java.awt.*;

public class ImageDisplay {
    protected JLabel image;

    public ImageDisplay(int w, int h, String imagePath) {
        this.image = new JLabel(scaleImage(w, h, imagePath));
    }

    public ImageIcon scaleImage(int w, int h, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        image = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    public void updateImage(String imagePath) {
        this.image.setIcon(scaleImage(150, 150, imagePath));
    }

    public Box getBox() {
        Box box = Box.createHorizontalBox();
        box.add(image);

        return box;
    }
}

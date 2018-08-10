package UI;

import Core.Game;
import GameObjects.Clickable;
import GameObjects.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CurrenyDisplay  {
    protected JLabel amount;
    protected JLabel production;
    protected JLabel image;
    protected Type type;

    public CurrenyDisplay(double amount, double production, String imagePath, Type type) {
        this.type = type;

        JLabel amountLabel = new JLabel("");
        amountLabel.setFont(new Font("Jokerman", Font.PLAIN, 35));
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.amount = amountLabel;
        updateAmount(amount);

        JLabel prodLabel = new JLabel("");
        prodLabel.setFont(new Font("Jokerman", Font.PLAIN, 24));
        prodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.production = prodLabel;
        updateProduction(production);

        ImageIcon icon = scaleImage(150, 150, new ImageIcon(imagePath));

        JLabel imageLabel = new JLabel(icon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (Game.getCurrency(type) instanceof Clickable) {
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Clickable c = (Clickable) Game.getCurrency(Type.WATER);
                    c.click();
                }
            });
        }

        this.image = imageLabel;
    }

    public ImageIcon scaleImage(int w, int h, ImageIcon icon) {
        Image image = icon.getImage();
        image = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    public void updateAmount(double amount) {
        this.amount.setText(String.format("%.3f %s %s", amount, Game.getCurrency(this.type).getMidfix(), this.type.toString()));
    }

    public void updateProduction(double production) {
        this.production.setText(String.format("Per second: %.3f %s", production, Game.getCurrency(this.type).getMidfix()));
    }

    public void updateImage(String imagePath) {
        this.image.setIcon(scaleImage(150, 150, new ImageIcon(imagePath)));
    }

    public Box getBox() {
        Box box = Box.createVerticalBox();

        box.add(amount);
        box.add(production);
        box.add(image);

        return box;
    }
}

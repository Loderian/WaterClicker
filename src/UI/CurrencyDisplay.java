package UI;

import Core.Game;
import GameObjects.Clickable;
import GameObjects.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CurrencyDisplay extends ImageDisplay  {
    protected Label amount;
    protected Label production;
    protected Type type;

    public CurrencyDisplay(double amount, double production, String imagePath, Type type) {
        super(150, 150, imagePath);

        this.type = type;

        this.amount = new Label(35);
        this.amount.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateAmount(amount);

        this.production = new Label(24);
        this.production.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateProduction(production);

        image.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (Game.getCurrency(type) instanceof Clickable) {
            image.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Clickable c = (Clickable) Game.getCurrency(Type.WATER);
                    c.click();
                }
            });
        }
    }


    public void updateAmount(double amount) {
        this.amount.setText(String.format("%.3f %s %s", amount, Game.getCurrency(this.type).getMidfix(), this.type.toString()));
    }

    public void updateProduction(double production) {
        this.production.setText(String.format("Per second: %.3f %s", production, Game.getCurrency(this.type).getMidfix()));
    }

    @Override
    public Box getBox() {
        Box box = Box.createVerticalBox();

        box.add(amount);
        box.add(production);
        box.add(image);

        return box;
    }
}

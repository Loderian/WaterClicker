package UI;

import javax.swing.*;
import java.awt.*;

public class BuildingDisplay extends ImageDisplay {
    protected Label name;
    protected Label amount;
    protected Label cost;

    public BuildingDisplay(String name, int amount, double cost, String imagePath) {
        super(50, 50, imagePath);

        this.name = new Label(name, 18);
        this.name.setAlignmentX(Container.CENTER_ALIGNMENT);
        this.name.setAlignmentY(Component.TOP_ALIGNMENT);

        this.cost = new Label(18);
        this.cost.setAlignmentX(Container.CENTER_ALIGNMENT);
        this.cost.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        updateCost(cost);

        this.amount = new Label(35);
        this.amount.setAlignmentX(Container.RIGHT_ALIGNMENT);
        updateAmount(amount);
    }

    private void updateCost(double cost) {
        this.cost.setText(String.format("%.3f", cost));
    }

    public void updateAmount(int amount) {
        this.amount.setText("" + amount);
    }

    public Box getBox() {
        Box box = super.getBox();
        box.setAlignmentX(Component.LEFT_ALIGNMENT);

        Box nameBox = Box.createVerticalBox();
        box.add(name);
        box.add(cost);
        nameBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        box.add(nameBox);

        box.add(amount);

        return box;
    }
}

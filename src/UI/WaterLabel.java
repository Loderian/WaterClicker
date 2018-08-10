package UI;

import java.awt.*;

public class WaterLabel extends Label {
    protected String midfix;

    public WaterLabel(String midfix) {
        super("water", 35);
        this.midfix = midfix;

        update(0);
    }

    public void setMidfix(String midfix) {
        this.midfix = midfix;
    }

    public void update(double amount) {
        setText(String.format("%.3f %s %s", amount, midfix, suffix));
    }
}

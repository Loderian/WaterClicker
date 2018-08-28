package GameObjects;

import Core.Game;
import UI.GameText;

public class Collector extends Producer {
    protected double bank;
    protected double capacity;

    public Collector(String name, double production, double cost, int owned, Type product, Type costType, double capacity) {
        super(name, production, cost, owned, product, costType);
        this.capacity = capacity;
        loadBank();
    }

    public double getCapacity() {
        return capacity * owned;
    }

    public void add(double amount) {
        bank += amount;
        if (bank > getCapacity()) {
            bank = getCapacity();
        }
    }

    public void loadBank() {
        bank = 0;
    }

    public String printBank() {
        return String.format("%s/%s", GameText.formatDouble(bank), GameText.formatDouble(getCapacity()));
    }

    @Override
    public void rightClick() {
        Game.getCurrency(product).add(this.bank);
        bank = 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void fixedUpdate() {
        if (bank < getCapacity()) {
            add(getTotalProduction()/50);
        }
    }
}

package GameObjects;

import Core.Game;
import UI.GameText;

import java.util.Collection;

abstract public class Currency implements GameObject {
    protected double bank;
    protected double production;
    protected double total;
    protected Type type;

    public Currency(double bank, Type type) {
        this.bank = bank;
        this.type = type;
        calcProduction();
    }

    @Override
    public void update() {
        calcProduction();
    }

    public void add(double amount) {
        this.bank += amount;
        this.total += amount;
    }

    public void sub(double amount) {
        this.bank -= amount;
    }

    public double getBank() {
        return bank;
    }

    public double getProduction() {
        return production;
    }

    public double getTotal() {
        return total;
    }

    public Type getType() {
        return type;
    }

    public void calcProduction() {
        Collection<Producer> producers = Game.getProducers();
        double prod = 0.0;
        for(Producer p : producers) {
            if (p.getProduct() == this.type) {
                prod += p.getTotalProduction();
            }
        }

        production = prod;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "bank=" + bank +
                ", production=" + production +
                ", total=" + total +
                ", type=" + type +
                "} " + super.toString();
    }

    public String printBank() {
        return String.format("%s %s %s", GameText.formatDouble(bank), getMidfix(), this.type.toString());
    }

    public String printProd() {
        return String.format("Per second: %s %s", GameText.formatDouble(production), getMidfix());
    }

    public String printTotal() {
        return String.format("Total %s collected: %s %s\n", type, GameText.formatDouble(total), getMidfix());
    }

    public String getMidfix() {
        switch (this.type) {
            case WATER:
                return "l";

            case FOOD:
                return "g";

            default:
                return "";
        }
    }


}

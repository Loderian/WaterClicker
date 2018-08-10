package GameObjects;

import Core.Game;

import java.util.Collection;

abstract public class Currency implements GameObject {
    protected double amount;
    protected double production;
    protected Type type;

    public Currency(double amount, Type type) {
        this.amount = amount;
        this.type = type;
        this.production = calcProduction();
    }

    public void add(double amount) {
        this.amount += amount;
    }

    public void sub(double amount) {
        this.amount -= amount;
    }

    public double getAmount() {
        return amount;
    }

    public double getProduction() {
        return production;
    }

    public double calcProduction() {
        Collection<Producer> producers = Game.getProducers();
        double prod = 0.0;
        for(Producer p : producers) {
            if (p.getProduct() == this.type) {
                prod += p.getProduction();
            }
        }

        production = prod;
        return prod;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "amount=" + amount +
                ", production=" + production +
                ", type=" + type +
                '}';
    }

    public String printAmount() {
        return String.format("%.3f %s %s", amount, getMidfix(), this.type.toString());
    }

    public String printProd() {
        return String.format("Per second: %.3f %s", production, Game.getCurrency(this.type).getMidfix());
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

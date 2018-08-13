package GameObjects;

import Core.Game;

import java.util.Collection;

abstract public class Currency extends Ordered implements GameObject {
    protected double bank;
    protected double production;
    protected double total;
    protected Type type;

    public Currency(final int pos, double bank, Type type) {
        super(pos);
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
                ", type=" + type +
                '}';
    }

    public String printAmount() {
        return String.format("%.3f %s %s", bank, getMidfix(), this.type.toString());
    }

    public String printProd() {
        return String.format("Per second: %.3f %s", production, getMidfix());
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

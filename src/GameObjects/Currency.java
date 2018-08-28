package GameObjects;

import Core.Game;
import UI.GameText;

import java.util.Collection;

abstract public class Currency implements GameObject {
    protected static double transaction = 0.1;
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
        if (this.bank < -0) {
            this.bank = 0;
        }
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

    public boolean canUse(Double d) {
        return this.bank - ((d) - Game.epsilon) >= 0.0;
    }

    public String printBank() {
        return String.format("%s %s %s", GameText.formatDouble(bank), getMidfix(), this.type.toString());
    }

    public String printProd() {
        return String.format("Per second: %s %s", GameText.formatDouble(production), getMidfix());
    }

    abstract public String printRate();

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

    public static double getRate(Type sell) {
        switch (sell) {
            case WATER:
                return 1;

            case FOOD:
                return 5;
        }
        return 0;
    }

    public static Void setTransaction(String input) {
        if (input.charAt(input.length()-1) == '%') {
            transaction = Integer.parseInt(input.substring(0,input.length()-1))/100.0;
        }
        return null;
    }
}

package GameObjects;

import Core.Game;

abstract public class Producer implements GameObject {
    protected double production;
    protected double cost;
    protected long owned;
    protected Type product;
    protected Type costType;


    public Producer(double production, double cost, long owned, Type product, Type costType) {
        this.production = production;
        this.cost = cost;
        this.owned = owned;
        this.product = product;
        this.costType = costType;
    }

    public double getProduction() {
        return production * owned;
    }

    public double getCost() {
        return cost + (cost * owned);
    }

    public void buy() {
        Currency c = Game.getCurrency(costType);
        if (c.getAmount() < getCost()) {
            Game.getCurrency(costType).sub(getCost());
        }
        owned++;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "production=" + getProduction() +
                ", cost=" + getCost() +
                ", owned=" + owned +
                ", product=" + product +
                ", costType=" + costType +
                '}';
    }
}

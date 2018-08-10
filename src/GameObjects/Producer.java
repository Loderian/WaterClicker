package GameObjects;

import Core.Game;

abstract public class Producer implements GameObject, Clickable {
    protected double production;
    protected Type product;

    protected double cost;
    protected Type costType;

    protected int owned;

    public Producer(double production, double cost, int owned, Type product, Type costType) {
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

    public Type getProduct() {
        return product;
    }

    public Type getCostType() {
        return costType;
    }

    public int getOwned() {
        return owned;
    }

    public void buy() {
        Currency c = Game.getCurrency(costType);
        if (c.getAmount() - (getCost() - 0.0000001) >= 0.0) {
            Game.getCurrency(costType).sub(getCost());
            owned++;
        }
    }

    @Override
    public void fixedUpdate() {
        Game.getCurrency(product).add(getProduction()/50);
    }

    @Override
    public void click() {
        buy();
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

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

    public void buy() {
        Currency c = Game.getCurrency(costType);
        if (c.getAmount() < getCost()) {
            Game.getCurrency(costType).sub(getCost());
        }
        owned++;
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

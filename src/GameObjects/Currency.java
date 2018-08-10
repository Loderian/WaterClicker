package GameObjects;

abstract public class Currency implements GameObject {
    protected double amount;
    protected Type type;

    public Currency(double amount, Type type) {
        this.amount = amount;
        this.type = type;
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

    @Override
    public String toString() {
        return "Currency{" +
                "amount=" + amount +
                '}';
    }
}

package GameObjects;

abstract public class Ordered {
    protected final int pos;

    public Ordered(final int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public String toString() {
        return "Ordered{" +
                "pos=" + pos +
                '}';
    }
}

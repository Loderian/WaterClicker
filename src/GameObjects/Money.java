package GameObjects;

public class Money extends Currency {
    public Money() {
        super(0, Type.MONEY);
    }

    @Override
    public void fixedUpdate() {

    }

    @Override
    public String printRate() {
        return "";
    }
}

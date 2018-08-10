package GameObjects;

public enum Type {
    WATER ("water"),
    FOOD ("food"),
    MONEY ("kr");

    private final String name;

    Type(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}

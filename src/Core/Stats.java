package Core;

import GameObjects.Currency;

public class Stats {
    private GameTime playtime;

    public Stats(long playtime) {
        this.playtime = new GameTime(playtime);
    }

    public void updateTime() {
        playtime.inc();
    }

    public String getPlaytime() {
        return playtime.toString();
    }

    @Override
    public String toString() {
        String str = "";
        for (Currency c : Game.getCurrencies()) {
            str += String.format("Total %s collected: %.3f %s\n", c.getType(), c.getTotal(), c.getMidfix());
        }
        str += getPlaytime();
        return str;
    }
}

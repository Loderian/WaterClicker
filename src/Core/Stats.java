package Core;

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
        return getPlaytime();
    }
}

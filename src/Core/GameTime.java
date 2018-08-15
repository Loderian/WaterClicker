package Core;

public class GameTime {
    private final long sYears = 31536000;
    private final long sDays = 86400;
    private final long sHours = 3600;
    private long seconds;

    public GameTime(long seconds) {
        this.seconds = seconds;
    }

    public void inc() {
        this.seconds++;
    }

    public long getYears() {
        return seconds / sYears;
    }

    public long getDays() {
        return Math.floorMod(seconds, sYears) / sDays;
    }

    public long getHours() {
        return Math.floorMod(Math.floorMod(seconds, sYears), sDays) / sHours;
    }

    public long getsMin() {
        return Math.floorMod(Math.floorMod(Math.floorMod(seconds, sYears), sDays), sHours) / 60;
    }

    public long getSeconds() {
        return Math.floorMod(Math.floorMod(Math.floorMod(Math.floorMod(seconds, sYears), sDays), sHours), 60);
    }

    @Override
    public String toString() {
        String str = "Total playtime: ";
        if (seconds > sYears) {
            return str + String.format("%d years, %d days, %d hours, %d minutes and %d seconds", getYears(), getDays(), getHours(), getsMin(), getSeconds());
        }
        else if (seconds > sDays) {
            return str + String.format("%d days, %d hours, %d minutes and %d seconds", getDays(), getHours(), getsMin(), getSeconds());
        }
        else if (seconds > sHours) {
            return str + String.format("%d hours, %d minutes and %d seconds", getHours(), getsMin(), getSeconds());
        }
        else if (seconds > 60) {
            return str + String.format("%d minutes and %d seconds", getsMin(), getSeconds());
        }
        else {
            return str + String.format("%d seconds", getSeconds());
        }
    }
}

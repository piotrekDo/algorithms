package holy_bible.sorting_algorithms;

class MyTime {
    private final long seconds;
    private final long minutes;
    private final long hours;
    private final long days;
    private long mils = 0;

    public MyTime(long miliseconds) {
        this.seconds = (miliseconds / 1000) % 60;
        this.minutes = (miliseconds / (1000 * 60)) % 60;
        this.hours = (miliseconds / (1000 * 60 * 60)) % 24;
        this.days = (miliseconds / (1000 * 60 * 60 *24));
    }

    public MyTime(long timeInSeconds, boolean fullInfo) {
        this(timeInSeconds);
        this.mils = fullInfo ? timeInSeconds : 0;
    }

    public static MyTime of(long timeInSeconds) {
        return new MyTime(timeInSeconds);
    }

    public static MyTime of(long timeInSeconds, boolean fullInfo) {
        return fullInfo ? new MyTime(timeInSeconds, true) : new MyTime(timeInSeconds);
    }


    @Override
    public String toString() {
        StringBuilder time = new StringBuilder();
        time.insert(0, " " + seconds + "s");
        if (minutes > 0)
            time.insert(0, " " + minutes + "min");
        if (hours > 0)
            time.insert(0, " " + hours + "hrs");
        if (days > 0)
            time.insert(0, " " + days + "days");
        if (mils > 0)
            time.append(". In miliseconds: ").append(mils);

        return time.toString();
    }
}

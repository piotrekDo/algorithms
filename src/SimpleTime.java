
public class SimpleTime {
    public static void main(String[] args) throws InterruptedException {

        long time = 54390;
        long sec;
        long minutes;
        long hours;

        if (time <= 60) {
            System.out.printf("Elapsed time: %ds", time);
        } else {
            if (time > 60) {
                sec = time % 60;
                minutes = time / 60;
                System.out.printf("Elapsed time: %dmin, %ds", minutes, sec);

                if (minutes > 59) {
                    hours = minutes / 60;
                    minutes = sec % 60;
                    System.out.printf("Elapsed time: %dhours, %dmin, %ds", hours, minutes, sec);
                }
            }
        }
    }
}

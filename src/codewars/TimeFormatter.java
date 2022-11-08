package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * * For seconds = 62, your function should return
 * "1 minute and 2 seconds"
 * * For seconds = 3662, your function should return
 * "1 hour, 1 minute and 2 seconds"
 * Detailed rules
 * <p>
 * The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
 * <p>
 * The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.
 * <p>
 * A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
 * <p>
 * Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
 * <p>
 * A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
 * <p>
 * A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
 */

public class TimeFormatter {
    //"1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    public static void main(String[] args) {

        System.out.println(formatDuration(286697897));
    }

    public static String formatDuration(int seconds) {
        return seconds == 0 ? "now" :
                Arrays.stream(
                                new String[]{
                                        formatTime("year", (seconds / 31536000)),
                                        formatTime("day", (seconds / 86400) % 365),
                                        formatTime("hour", (seconds / 3600) % 24),
                                        formatTime("minute", (seconds / 60) % 60),
                                        formatTime("second", (seconds % 3600) % 60)})
                        .filter(e -> e != "")
                        .collect(Collectors.joining(", "))
                        .replaceAll(", (?!.+,)", " and ");
    }

    public static String formatTime(String s, int time) {
        return time == 0 ? "" : time + " " + s + (time == 1 ? "" : "s");
    }
}

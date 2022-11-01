package holy_bible.sorting_algorithms;

public interface Sorting {

    String name();

    int[] sort(int[] ints);

    default int[] printResult(int[] ints) {
        long start = System.currentTimeMillis();
        int[] sort = sort(ints);
        long end = System.currentTimeMillis();

        System.out.printf("%s done with %,d elements in %s%n",
                name(), ints.length, MyTime.of(end - start, false));

        return sort;
    }

    default int[] printResult(int[] ints, boolean fullInfo) {
        long start = System.currentTimeMillis();
        int[] sort = sort(ints);
        long end = System.currentTimeMillis();

        System.out.printf("%s done with %,d elements in%s%n",
                name(), ints.length, MyTime.of(end - start, fullInfo));

        return sort;
    }
}

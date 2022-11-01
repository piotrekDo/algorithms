package holy_bible.sorting_algorithms;

class BubbleSort implements Sorting {

    @Override
    public String name() {
        return "Bubble sort";
    }

    @Override
    public int[] sort(int[] ints) {
        int len = ints.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - i - 1; ++j) {
                if (ints[j + 1] < ints[j]) {
                    int swap = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = swap;
                }
            }
        }
        return ints;
    }
}


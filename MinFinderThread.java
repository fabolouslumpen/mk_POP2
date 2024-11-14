public class MinFinderThread extends Thread {
    private final int[] array;
    private final int start;
    private final int end;

    public MinFinderThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int localMin = array[start];
        int localMinIndex = start;

        for (int i = start + 1; i < end; i++) {
            if (array[i] < localMin) {
                localMin = array[i];
                localMinIndex = i;
            }
        }

        Main.updateMin(localMin, localMinIndex);

//        System.out.println(getName() + " min: " + localMin + " index: " + localMinIndex);
    }
}

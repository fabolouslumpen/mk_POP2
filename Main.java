public class Main {
    private static int min = Integer.MAX_VALUE;
    private static int minIndex = -1;

    public static void main(String[] args) {
        int length = 11111111;
        int[] array = new int[length];

        ArrayFiller.fillArray(array);

        int numThreads = 5;
        int partSize = array.length / numThreads;

        MinFinderThread[] threads = new MinFinderThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * partSize;
            int end = (i == numThreads - 1) ? array.length : (i + 1) * partSize;

            threads[i] = new MinFinderThread(array, start, end);
            threads[i].start();
        }

        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nmin: " + min + " index: " + minIndex);
    }

    public synchronized static void updateMin(int localMin, int localMinIndex) {
        if (localMin < min) {
            min = localMin;
            minIndex = localMinIndex;

//            System.out.println("new min: " + min + " index: " + minIndex);
        }
    }
}

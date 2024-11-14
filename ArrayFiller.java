public class ArrayFiller {
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * array.length);
        }

        int negativeIndex = (int)(Math.random() * array.length);
        array[negativeIndex] = -array[negativeIndex];
    }
}

package divideandconquer;

import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] ints, int rightIndex) {
        if (rightIndex <= 0) {
            return;
        }
        for (int i = rightIndex; i >= 0; i--) {
            if (i >= 2 && i % 2 == 0) {
                if (ints[i] >= ints[i - 1] && ints[i] > ints[i / 2 - 1]) {
                    swap(ints, i, i / 2 - 1);
                } else if (ints[i - 1] >= ints[i] && ints[i - 1] > ints[i / 2 - 1]) {
                    swap(ints, i - 1, i / 2 - 1);
                }
                i--;
            } else if (i >= 1 && i % 2 == 1) {
                if (ints[i] > ints[i / 2]) {
                    swap(ints, i, i / 2);
                }
            }
        }
        swap(ints, 0, rightIndex);
        heapSort(ints, rightIndex - 1);
    }

    private void swap(int[] ints, int a, int b) {
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 5, 6, 7, 3, 6, 3, 5, 8, 9};
        new HeapSort().heapSort(ints, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
}

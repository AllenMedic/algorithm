package divideandconquer;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] ints, int low, int high) {
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int key = ints[left];
        while (left < right) {
            while (left < right && key <= ints[right]) {
                right--;
            }
            while (left < right && ints[left] <= key) {
                left++;
            }
            if (left < right) {
                swap(ints, left, right);
            }
        }
        swap(ints, low, left);
        quickSort(ints, low, left - 1);
        quickSort(ints, left + 1, high);
    }

    public void swap(int[] ints, int left, int right) {
        int temp = ints[left];
        ints[left] = ints[right];
        ints[right] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 5, 6, 7, 3, 6, 3, 5, 8, 9};
        new QuickSort().quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
}

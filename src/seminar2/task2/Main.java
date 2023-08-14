package seminar2.task2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int size = 100;
        int min = 0;
        int max = 100;

        int[] arr = getArray(size, min, max);

        printArray(arr);

        quickSort(arr,0, size - 1);
        printArray(arr);


    }

    public static int[] getArray(int size, int min, int max) {
        Random random = new Random();

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) - 1) + min;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    /**
     * @apiNote method of quick sort of the array
     * @param arr - array
     * @param startPosition  - start point
     * @param endPosition - end point
     * @pivot - point of pivot
     */

    public static void quickSort(int[] arr, int startPosition, int endPosition) {
        int pivot = arr[(startPosition + endPosition) / 2];
        int i = startPosition;
        int j = endPosition;

        while (i <= j) {
            while(arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if(i <= j) {
                if(i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                i++;
                j--;
            }
        }
        if(i < endPosition) {
            quickSort(arr, i, endPosition);
        }
        if(j > startPosition) {
            quickSort(arr, startPosition, j);
        }

    }


}

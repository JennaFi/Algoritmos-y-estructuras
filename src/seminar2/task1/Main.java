package seminar2.task1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int size = 100;
        int min = 0;
        int max = 100;

        int[] arr = getArray(size, min, max);

        printArray(arr);

        bubbleSort(arr);

        printArray(arr);

    }

    /**
     * @apiNote bubble sort method
     * print array method
     * get array - random fill array method
     * @param arr array to sort
     */

    public static void bubbleSort(int[] arr) {
        boolean fin;

        do {
            fin = true;

            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    arr[i] += arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] -= arr[i + 1];

                    fin = false;
                }

            }

        } while (!fin);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static int[] getArray(int size, int min, int max) {
        Random random = new Random();

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) - 1) + min;
        }
        return arr;
    }

}

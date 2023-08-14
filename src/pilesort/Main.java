package pilesort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 100;
        int min = 0;
        int max = 100;

        int[] arr = getArray(size, min, max);

        printArray(arr);
        pileSort(arr);
        printArray(arr);


    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.print(" ");
        System.out.println(" ");
    }

    public static int[] getArray(int size, int min, int max) {
        Random random = new Random();

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) - 1) + min;
        }
        return arr;
    }

    //    возвращает левого потомка A[i]`
    private static int leFt(int i) {
        return (2 * i + 1);
    }

    //   возвращает правого потомка `A[i]`
    private static int riGhT(int i) {
        return (2 * i + 2);
    }

    //вспомогательная функция для замены двух индексов в массиве
    private static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    private static void heapify(int[] arr, int i, int size) {
        // получает левый и правый потомки узла с индексом `i`
        int left = leFt(i);
        int right = riGhT(i);
        int largest = i;

        //сравниваем `A[i]` с его левым и правым дочерними элементами и находим наибольшее значение
        if (left < size && arr[left] > arr[i]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;

        //меняет местами с потомком, имеющим большее значение и вызовите heapify-down для дочернего элемента
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, size);
        }
    }

    //функция для удаления элемента с наивысшим приоритетом
    public static int pop(int[] arr, int size) {
        //если в куче нет элементов
        if (size <= 0) {
            return -1;
        }
        int top = arr[0];

        //заменяем корень кучи последним элементом массива
        arr[0] = arr[size-1];

        heapify(arr, 0, size - 1);
        return top;
    }

    //функция для выполнения пирамидальной сортировки массива `A` размера `n`
    public static void pileSort(int[] arr) {

        //строим приоритетную очередь и инициализируем ее заданным массивом
        int n = arr.length;

        //build-heap: вызывать heapify, начиная с последнего внутреннего
        //узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(arr, i--, n);
        }

        //несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            arr[n - 1] = pop(arr, n);
            n--;
        }
    }

}

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(1000);
        int[] largeArray = generateRandomArray(10000);

        // Сортировка пузырьком
        long startTime = System.nanoTime();
        bubbleSort(smallArray.clone());
        long endTime = System.nanoTime();
        System.out.println("Time for bubble sort: " + (endTime - startTime));

        startTime = System.nanoTime();
        bubbleSort(largeArray.clone());
        endTime = System.nanoTime();
        System.out.println("Time for bubble sort (big massive): " + (endTime - startTime));

        // Быстрая сортировка
        startTime = System.nanoTime();
        quickSort(smallArray.clone(), 0, smallArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Time for quick sort:" + (endTime - startTime));

        startTime = System.nanoTime();
        quickSort(largeArray.clone(), 0, largeArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Time for quick sort (big massive): " + (endTime - startTime));
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }
}
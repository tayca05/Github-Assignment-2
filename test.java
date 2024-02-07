import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayOperations {
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create random array");
            System.out.println("2. Find minimum and maximum");
            System.out.println("3. Find average and differences from average");
            System.out.println("4. Find sum of elements with odd- and even-numbered indexes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter array size: ");
                    int size = scanner.nextInt();
                    createRandomArray(size);
                    break;
                case 2:
                    findMinMax();
                    break;
                case 3:
                    findAverageAndDifferences();
                    break;
                case 4:
                    findSumOfIndexes();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }

    private static void createRandomArray(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101); // Generating random integers in the range [0, 100]
        }
        System.out.println("Random array created: " + Arrays.toString(array));
    }

    private static void findMinMax() {
        if (array == null) {
            System.out.println("Array not created yet!");
            return;
        }
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }

    private static void findAverageAndDifferences() {
        if (array == null) {
            System.out.println("Array not created yet!");
            return;
        }
        double sum = Arrays.stream(array).sum();
        double average = sum / array.length;
        System.out.println("Average: " + average);
        System.out.print("Differences from average: ");
        for (int num : array) {
            System.out.print((num - average) + " ");
        }
        System.out.println();
    }

    private static void findSumOfIndexes() {
        if (array == null) {
            System.out.println("Array not created yet!");
            return;
        }
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumEven += array[i];
            } else {
                sumOdd += array[i];
            }
        }
        System.out.println("Sum of elements with odd indexes: " + sumOdd);
        System.out.println("Sum of elements with even indexes: " + sumEven);
    }
}

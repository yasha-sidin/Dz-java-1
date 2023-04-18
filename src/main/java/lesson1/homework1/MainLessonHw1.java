package lesson1.homework1;
import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainLessonHw1 {
    public static void main(String[] args) {
        // Task1
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Task1\nВведите количество элементов в массиве: ");
        int len = iScanner.nextInt();
        System.out.print("Введите число, которым будет заполнен весь массив: ");
        int initialValue = iScanner.nextInt();
        Task1(len, initialValue);
        iScanner.close();
        System.out.println();

        // Task2
        System.out.println("Task2");
        Task2();
        System.out.println();

        // Task3
        System.out.println("Task3");
        Task3(10,10);
        System.out.println();

        // Task4
        System.out.println("Task4");
        Task4("Yasha");
    }
    private static void Task1(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void Task2() {
        Random random = new Random();
        int[] arr = new int[random.nextInt(2, 10)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 101);
        }
        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.printf("%d - Максимальный элемент массива\n%d - Минимальный элемент массива\n", max, min);
    }

    private static void Task3(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                if (j + i == columns - 1) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == columns - 1) {
                    System.out.println(arr[i][j]);
                    break;
                }
                System.out.print(arr[i][j]);
            }
        }
    }

    private static void Task4(String name) {
        LocalTime time = LocalTime.now();
        String timeNow = time.toString().substring(0, 8);
        System.out.println(timeNow);

        int hour;
        if (Integer.parseInt(timeNow.substring(0, 1)) == 0) {
            hour = Integer.parseInt(timeNow.substring(1, 2));
        }
        else {
            hour = Integer.parseInt(timeNow.substring(0, 2));
        }

        if (hour >= 5 && hour <= 11) {
            System.out.printf("Доброе утро, %s!", name);
        }
        if (hour >= 12 && hour <= 17) {
            System.out.printf("Добрый день, %s!", name);
        }
        if (hour >= 18 && hour <= 22) {
            System.out.printf("Добрый вечер, %s!", name);
        }
        if (hour >= 23 || (hour >= 0 && hour <= 4)) {
            System.out.printf("Доброй ночи, %s!", name);
        }
    }
}

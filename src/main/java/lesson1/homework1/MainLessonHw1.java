package lesson1.homework1;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
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

        // Task2
        System.out.println("Task2");
        Task2();
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
}

package lesson1;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
//Написать программу, которая запросит пользователя ввести <Имя> в консоли.
// Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”

public class Main {
    public static void main(String[] args){
//        ex1();
        System.out.println();
//        ex2();
        System.out.println();
        ex3();
        System.out.println();
//        ex4();
//        ex5(3, -2);
        System.out.println();
//       ex6("Kate\tSmith\t20\nPaul\tGreen\t25\nMike\tBlack\t23");

    }

    private static void ex1() {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите ваше имя: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!", name);
    }


    //    Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.

    private static void ex2() {
        int [] arr = new int[]{1, 1, 0, 1, 1, 1};
        int count = 0;
        int maxValue = 0;
        for (int i: arr) {
            if (i == 1) count++;
            else {
                if (count > maxValue) {
                    maxValue = count;
                    count = 0;
                }
            }
        }
        if (count > maxValue) maxValue = count;
        System.out.println(maxValue);
    }
    // Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

    private static void ex3() {
        Random random = new Random();
        int[] arr = new int[20];
        final int VAL = 3;

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = random.nextInt(1, 7);
        }

        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[right] == VAL) {
                right--;
            } else if (arr[left] != VAL) {
                left++;
            } else {
                arr[left] = arr[right];
                arr[right] = VAL;

                right--;
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void ex4() {
        String str = "Добро пожаловать на курс по Java";
        String[] words = str.split(" ");
        String temp;
        for (int i = 0; i < words.length / 2; i++) {
            temp = words[words.length - 1 - i];
            words[words.length - 1 - i] = words[i];
            words[i] = temp;
        }
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
    }
    private static void ex5(double a, int b) {
        double result = 1;
        if (b == 0) {
            result = 0;
            System.out.println(result);
        }
        if (b > 0) {
            for (int i = 1; i <= b; i++) {
                result *= a;
            }
            System.out.println(result);
        }
        if (b < 0) {
            for (int i = 1; i <= (-1) * b; i++) {
                result *= 1 / a;
            }
            System.out.println(result);
        }


    }
//    Записать в файл следующие данные:
//
//    Name Surname Age
//    Kate Smith 20
//    Paul Green 25
//    Mike Black 23
    private static void ex6(String str) {
        try (FileWriter fw = new FileWriter("GB_java_s01.txt",Charset.forName("UTF-8"), false)) {
            fw.write("Name\tSurname\tAge\n");
            fw.append("Kate\tSmith\t20\nPaul\tGreen\t25\nMike\tBlack\t23");
            fw.flush();

        } catch (Exception ex) {
            System.out.println("Some error: " + ex.getMessage());
        }
    }
    // В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
    // "Доброе утро, <Имя>!", если время от 05:00 до 11:59
    // "Добрый день, <Имя>!", если время от 12:00 до 17:59;

    // "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    // "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
}

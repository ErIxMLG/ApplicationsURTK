package DZ2;

import java.util.Random;
public class Task3 {
    public static void randomMassive(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Задание 3");

        Random random = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("Массив из 10 случайных чисел от 1 до 100:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

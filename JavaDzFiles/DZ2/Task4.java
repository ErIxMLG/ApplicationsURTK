package DZ2;

import java.util.Random;
public class Task4 {
    public static int[] changeForZero() {

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Задание 4");

        Random random = new Random();
        int[] massive = new int[10];

        System.out.println("Сгенерированный массив до изменения:");

        for (int i = 0; i < massive.length; i++) {
            massive[i] = random.nextInt(101) - 50;
            System.out.print(massive[i] + " ");
        }

        System.out.println(" ");
        System.out.println("Измененный массив:");

        for (int i = 0; i < massive.length; i++) {
            if (massive[i] <= 0) {
                massive[i] = 0;
            }
            System.out.print(massive[i] + " ");
        }
        return massive;
    }
}

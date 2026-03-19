package DZ2;

import java.util.Scanner;
public class Task2 {
    public static void valuePrint(Scanner scanner){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Задание 2");

        System.out.print("Введите начальное число: ");
        int startValue = scanner.nextInt();

        for (int i = startValue; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }
}

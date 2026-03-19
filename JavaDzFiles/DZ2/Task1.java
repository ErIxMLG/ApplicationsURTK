package DZ2;

import java.util.Scanner;
public class Task1 {
    public static void highestValue(Scanner scanner){
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("Задание 1");

    System.out.print("Введите первое число: ");
    int firstInt = scanner.nextInt();

    System.out.print("Введите второе число: ");
    int secondInt = scanner.nextInt();

    System.out.print("Введите третье число: ");
    int thirdInt = scanner.nextInt();

    int max = firstInt;

    if (secondInt > max) {
        max = secondInt;
    }
    if (thirdInt > max) {
        max = thirdInt;
    }
    System.out.println("Наибольшее число: " + max);
    }
}

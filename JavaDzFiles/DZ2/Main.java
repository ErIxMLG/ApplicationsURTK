package DZ2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Задание 1
        Task1.highestValue(scanner);

        // Задание 2
        Task2.valuePrint(scanner);

        // Задание 3
        Task3.randomMassive();

        // Задание 4
        int[] arr = Task4.changeForZero();

        // Задание 5
        Task5.countZero(arr);
    }
}
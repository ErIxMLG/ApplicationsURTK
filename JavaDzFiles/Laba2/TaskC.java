import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskC {
    
    // Задание C2
    public static void task_C2(Scanner scanner) {
        System.out.println("\nC2");
        System.out.println("Обработка некорректного ввода целого числа");
        int number;
        
        try {
            System.out.print("Введите целое число: ");
            number = scanner.nextInt();
            System.out.println("Вы ввели число: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число. Попробуйте снова.");
            scanner.nextLine();
        }
    }

    // Задание C7 
    public static void task_C7(Scanner scanner) {
        System.out.println("\nC7");
        System.out.println("Проверка ввода размера массива");
        
        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть положительным числом");
            }
            
            int[] array = new int[size];
            System.out.println("Массив размером " + array.length + " успешно создан");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: размер массива не может быть отрицательным");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
    
    // Задание C8
    public static void task_C8(Scanner scanner) {
        System.out.println("\nC8");
        System.out.println("Обработка NullPointerException");
        String text = null;
        try {
            if (text == null) {
                throw new NullPointerException("Строка не инициализирована");
            }
        } catch (NullPointerException e) {
            System.out.println("Обработано исключение: " + e.getMessage());
        }
    }
    
    // Задание C12
    public static void task_C12(Scanner scanner) {
        System.out.println("\nC12");
        System.out.println("Вывод сообщения об ошибке из объекта Exception");
        
        try {
            int result = 10/0;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Тип исключения: " + e.getClass().getName());
            System.out.println("Сообщение об ошибке: " + e.getMessage());
            System.out.println("Полная информация: " + e.toString());
        }
    }
    
    // Вспомогательная функция
    private static double dividePositive(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException(
                "Деление отрицательных чисел запрещено. Переданы значения: a= " + a + ", b= " + b
            );
        }
        if (a == 0 || b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (double) a / b;
    }

    // Задание C17
    public static void task_C17(Scanner scanner) {
        System.out.println("\nC17");
        System.out.println("Исключение при делении отрицательных чисел");
        
        try {
            double result1 = dividePositive(10, 2);
            System.out.println("Результат 10/2 = " + result1);
            
            double result2 = dividePositive(2, 0);
            System.out.println("Результат 2/0 = " + result2);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка деления: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль");
        }
        
        try {
            double result3 = dividePositive(5, -3);
            System.out.println("Результат 5/-3 = " + result3);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка деления: " + e.getMessage());
        }
    }
}
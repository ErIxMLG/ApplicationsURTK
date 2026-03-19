import java.util.Scanner;

/**
 * Задание 5: Создать программу с try, catch и finally, 
 * демонстрирующую их работу.
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Демонстрация работы try-catch-finally");
        
        try {
            System.out.println("Блок try начал выполнение");
            
            System.out.print("Введите число: ");
            int number = scanner.nextInt();
            
            System.out.print("Введите делитель: ");
            int divisor = scanner.nextInt();
            
            System.out.println("Выполняется деление...");
            int result = number / divisor;
            
            System.out.println("Результат: " + number + " / " + divisor + " = " + result);
            System.out.println("Блок try завершился успешно");
            
        } catch (ArithmeticException e) {
            System.out.println("\nБлок catch перехватил ArithmeticException");
            System.out.println("Ошибка: деление на ноль!");
        } catch (Exception e) {
            System.out.println("\nБлок catch перехватил Exception");
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("\nБлок finally выполняется");
            System.out.println("Программа завершена.");
            scanner.close();
        }
    }
}

import java.util.Scanner;

/**
 * Задание 2: Ввести строку и преобразовать её в число. 
 * Обработать ошибку неверного формата.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите строку для преобразования в число: ");
            String input = scanner.nextLine();
            
            int number = Integer.parseInt(input);
            System.out.println("Успешно преобразовано в число: " + number);
            
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: строка не является числом!");
            System.out.println("Детали: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

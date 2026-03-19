import java.util.Scanner;

/**
 * Задание 8: Проверить, является ли строка палиндромом.
 */
public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        // Убираем пробелы и приводим к нижнему регистру
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        
        // Переворачиваем строку
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        boolean isPalindrome = cleaned.equals(reversed);
        
        System.out.println("Введённая строка: \"" + input + "\"");
        System.out.println("Обработанная строка: \"" + cleaned + "\"");
        System.out.println("Перевёрнутая строка: \"" + reversed + "\"");
        
        if (isPalindrome) {
            System.out.println("Это палиндром.");
        } else {
            System.out.println("Это НЕ палиндром.");
        }
        
        scanner.close();
    }
}

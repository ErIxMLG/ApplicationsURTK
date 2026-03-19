import java.util.Scanner;

/**
 * Задание 9: Разбить строку на слова и вывести каждое с новой строки.
 */
public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        // Разбиваем строку по пробелам
        String[] words = input.split("\\s+");
        
        System.out.println("\nВсего слов: " + words.length);
        System.out.println("\nСлова:");
        
        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ". " + words[i]);
        }
        
        scanner.close();
    }
}

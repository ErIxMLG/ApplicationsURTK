import java.util.Scanner;

/**
 * Задание 10: Заменить все пробелы в строке символом _.
 */
public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        // Заменяем все пробелы на подчёркивание
        String result = input.replace(" ", "_");
        
        System.out.println("\nИсходная строка: \"" + input + "\"");
        System.out.println("Результат:       \"" + result + "\"");
        
        scanner.close();
    }
}

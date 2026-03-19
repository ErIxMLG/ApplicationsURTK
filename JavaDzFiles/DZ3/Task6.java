import java.util.Scanner;

/**
 * Задание 6: Ввести строку и вывести её длину.
 */
public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        int length = input.length();
        
        System.out.println("Длина строки: " + length);
        System.out.println("Введённая строка: \"" + input + "\"");
        
        scanner.close();
    }
}

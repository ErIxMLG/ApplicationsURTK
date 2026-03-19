import java.util.Scanner;

/**
 * Задание 7: Подсчитать количество гласных букв в строке.
 */
public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        int count = 0;
        String asd = "аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY";
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (asd.indexOf(ch) != -1) {
                count++;
            }
        }
        
        System.out.println("Количество гласных букв: " + count);
        System.out.println("Введённая строка: " + input);
        
        scanner.close();
    }
}

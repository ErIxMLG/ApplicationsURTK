import java.util.Scanner;

/**
 * Задание 4: Ввести возраст пользователя. 
 * Если возраст отрицательный — выбросить исключение.
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите ваш возраст: ");
            int age = scanner.nextInt();
            
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным!");
            }
     
            System.out.println("Ваш возраст: " + age + " лет");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка ввода данных!");
        } finally {
            scanner.close();
        }
    }
}

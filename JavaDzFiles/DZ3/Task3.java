import java.util.Scanner;

/**
 * Задание 3: Создать массив из 5 элементов. 
 * Обработать ошибку выхода за границы массива.
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 20, 30, 40, 50};
        
        System.out.println("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
        
        try {
            System.out.print("Введите индекс элемента (0-4): ");
            int index = scanner.nextInt();
            
            System.out.println("Элемент по индексу " + index + ": " + array[index]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива!");
            System.out.println("Допустимые индексы: от 0 до " + (array.length - 1));
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

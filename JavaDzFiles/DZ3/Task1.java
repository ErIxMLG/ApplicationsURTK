import java.util.Scanner;

/*
Задание 1: Обработать деление двух чисел, введённых с клавиатуры. 
Учесть деление на ноль.
*/
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();
            
            if (num2 == 0) {
                throw new ArithmeticException("Деление на ноль!");
            }
            
            double result = num1 / num2;
            System.out.println("Результат деления: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        // Блок А
        int[] arr = {1,7,9,3,-12,34,23,7,346};
        TaskA.task_A3(arr);
        TaskA.task_A5(arr);
        TaskA.task_A10(arr);
        TaskA.task_A15(arr);
        TaskA.task_A20(arr);

        // Блок В
        String message = "34567 chocolate poop helicopter zhuikov";
        TaskB.task_B1(message);
        TaskB.task_B4(message);
        TaskB.task_B6(message);
        TaskB.task_B11(message);
        TaskB.task_B16(message);

        // Блок С
        Scanner scanner = new Scanner(System.in);
        TaskC.task_C2(scanner);
        TaskC.task_C7(scanner);
        TaskC.task_C8(scanner);
        TaskC.task_C12(scanner);
        TaskC.task_C17(scanner);
    }
}

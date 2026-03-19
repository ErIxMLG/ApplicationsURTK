package DZ2;

public class Task5 {
    public static void countZero(int[] massive){

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Задание 5");

        System.out.print("Массив: ");
        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + " ");
        }

        int zeros = 0;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == 0){
                zeros++;
            }
        }
        System.out.println(" ");
        System.out.println("Количество нулей в массиве = " + zeros);
    }
}

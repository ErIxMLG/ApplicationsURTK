public class TaskA {

    // Задание А3
    public static void task_A3(int[] massive) {
        System.out.println("\nA3");
        System.out.println("Массив: ");
        for (int i = 0; i < massive.length; i++){
            System.out.print(massive[i] + " ");
        }
        System.out.println("");

        System.out.println("Минимальный элемент: ");
        int minimal = 0;
        for (int i = 0; i < massive.length; i++){
            if (minimal > massive[i]){
                minimal = massive[i];
            }
        }
        System.out.println(minimal);
    }

    // Задание А5
    public static void task_A5(int[] massive){
        System.out.println("\nA5");
        System.out.println("Массив: ");
        for (int i = 0; i < massive.length; i++){
            System.out.print(massive[i] + " ");
        }
        System.out.println("");

        System.out.println("Количество нечетных элементов: ");
        int count = 0;
        for (int i = 0; i < massive.length; i++){
            if (massive[i] % 2 == 0){
                count++;
            }
        }
        System.out.println(count);
    }

    // Задание А10
    public static void task_A10(int[] massive){
        System.out.println("\nA10");
        System.out.println("Замена отрицательных на 0");
        System.out.println("Массив без изменений: ");

        for (int i = 0; i < massive.length; i++){
            System.out.print(massive[i] + " ");
        }

        System.out.println("\nМассив с изменениями: ");

        for (int i = 0; i < massive.length; i++){
            if (massive[i] < 0){
                massive[i] = 0;
            }
            System.out.print(massive[i] + " ");
        }
        System.out.println("");
    }

    // Задание А15
    public static void task_A15(int[] massive){
        System.out.println("\nA15");
        System.out.println("Массив: ");
        for (int i = 0; i < massive.length; i++){
            System.out.print(massive[i] + " ");
        }
        System.out.println("");

        System.out.println("Второй по величине элемент: ");
        int minimal2 = 0;
        int minimal = 0;
        for (int i = 0; i < massive.length; i++){
            if (massive[i] > minimal){
                minimal2 = minimal;
                minimal = massive[i];
            } else if ((massive[i] > minimal2 && (massive[i] != minimal))) {
                minimal2 = massive[i];
            }
        }
        System.out.println(minimal2);
    }

    // Задание А20
    public static void task_A20(int[] massive){
        System.out.println("\nA20");
        System.out.println("Массив: ");
        for (int i = 0; i < massive.length; i++){
            System.out.print(massive[i] + " ");
        }
        System.out.println("");
        
        System.out.println("Скопированный массив: ");
        int[] massive2 = massive;
        for (int i = 0; i<massive2.length; i++){
            System.out.print(massive2[i] + " ");
        }
        System.out.println(" ");
    }
}

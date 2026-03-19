public class TaskB {

    // Задание В1
    public static void task_B1(String msg){
        System.out.println("\nB1");
        System.out.println("Вывести строку и ее длину");
        System.out.println("Строка: " + msg);
        System.out.println("Длина строки: " + msg.length());
    }

    // Задание В4
    public static void task_B4(String msg){
        System.out.println("\nB4");
        System.out.println("Подсчитать количество цифр в строке");
        System.out.println("Строка: " + msg);
        
        String numbers = "0123456789";
        int count = 0;
        for (int i = 0; i<msg.length() ; i++){
            for (int v = 0; v<numbers.length() ; v++){
                if (msg.charAt(i) == numbers.charAt(v)){
                    count++;
                }
            }
        }
        System.out.println("Количество цифр в строке: " + count);
    }

    // Задание В6
    public static void task_B6(String msg){
        System.out.println("\nB6");
        System.out.println("Вывести самое длинное слово");
        System.out.println("Строка: " + msg);

        String[] words = msg.split("\\s+");

        String word = "";
        for (String word1 : words) {
            if (word.length() < word1.length()) {
                word = word1;
            }
        }
        System.out.println("Самое длинное слово в строке: " + word);
    }

    // Задание В11
    public static void task_B11(String msg){
        System.out.println("\nB11");
        System.out.println("Вывести строку без пробелов");
        System.out.println("Строка: " + msg);

        String result = msg.replace(" ", "");
        System.out.println("Строка без пробелов: " + result);
    }

    // Задание В16
    public static void task_B16(String msg){
        System.out.println("\nB16");
        System.out.println("Вывести первое и последнее слово строки");
        System.out.println("Строка: " + msg);
        
        String[] words = msg.split("\\s+");

        System.out.println("Первое слово строки: " + words[0]);
        System.out.println("Последнее слово строки: " + words[words.length-1]);
    }
}

import java.util.Scanner;

/**
 * Главный класс приложения для учёта сотрудников организации
 */
public class Main {
    private static final String FILENAME = "C:\\Users\\ErL\\Desktop\\vscode\\JavaDZ\\Laba4\\employees.txt";
    private static EmployeeManager manager = new EmployeeManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("     СИСТЕМА УЧЁТА СОТРУДНИКОВ ОРГАНИЗАЦИИ");
        System.out.println("=".repeat(60) + "\n");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    manager.displayAllEmployees();
                    break;
                case 3:
                    findEmployee();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    loadFromFile();
                    break;
                case 0:
                    running = false;
                    System.out.println("\n✓ Программа завершена. До свидания!");
                    break;
                default:
                    System.out.println("\n✗ Неверный выбор. Попробуйте снова.\n");
            }
        }

        scanner.close();
    }

    /**
     * Отображение меню
     */
    private static void displayMenu() {
        System.out.println("┌" + "─".repeat(58) + "┐");
        System.out.println("│                         МЕНЮ                             │");
        System.out.println("├" + "─".repeat(58) + "┤");
        System.out.println("│  1 — Добавить сотрудника                                 │");
        System.out.println("│  2 — Показать всех сотрудников                           │");
        System.out.println("│  3 — Найти сотрудника                                    │");
        System.out.println("│  4 — Сохранить в файл                                    │");
        System.out.println("│  5 — Загрузить из файла                                  │");
        System.out.println("│  0 — Выход                                               │");
        System.out.println("└" + "─".repeat(58) + "┘");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Получение выбора пользователя с обработкой ошибок
     */
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Неверный ввод
        }
    }

    /**
     * Добавление нового сотрудника
     */
    private static void addEmployee() {
        System.out.println("\n" + "─".repeat(60));
        System.out.println("ДОБАВЛЕНИЕ НОВОГО СОТРУДНИКА");
        System.out.println("─".repeat(60));

        try {
            System.out.print("Введите ФИО: ");
            String fullName = scanner.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("✗ ФИО не может быть пустым!\n");
                return;
            }

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age < 18 || age > 100) {
                System.out.println("✗ Возраст должен быть от 18 до 100 лет!\n");
                return;
            }

            System.out.print("Введите должность: ");
            String position = scanner.nextLine().trim();
            if (position.isEmpty()) {
                System.out.println("✗ Должность не может быть пустой!\n");
                return;
            }

            System.out.print("Введите размер заработной платы: ");
            double salary = Double.parseDouble(scanner.nextLine());
            if (salary < 0) {
                System.out.println("✗ Зарплата не может быть отрицательной!\n");
                return;
            }

            Employee employee = new Employee(fullName, age, position, salary);
            manager.addEmployee(employee);
            System.out.println("─".repeat(60) + "\n");

        } catch (NumberFormatException e) {
            System.out.println("✗ Ошибка: неверный формат числа!\n");
        }
    }

    /**
     * Поиск сотрудника по ФИО
     */
    private static void findEmployee() {
        System.out.println("\n" + "─".repeat(60));
        System.out.println("ПОИСК СОТРУДНИКА");
        System.out.println("─".repeat(60));
        
        System.out.print("Введите ФИО (или часть ФИО) для поиска: ");
        String searchName = scanner.nextLine().trim();

        if (searchName.isEmpty()) {
            System.out.println("✗ Поисковый запрос не может быть пустым!\n");
            return;
        }

        manager.findEmployee(searchName);
    }

    /**
     * Сохранение данных в файл через отдельный поток
     */
    private static void saveToFile() {
        if (manager.getEmployeeCount() == 0) {
            System.out.println("\n✗ Нет данных для сохранения! Сначала добавьте сотрудников.\n");
            return;
        }

        // Создаём задачу для сохранения
        FileSaveTask saveTask = new FileSaveTask(manager.getEmployees(), FILENAME);
        
        // Создаём и запускаем поток
        Thread saveThread = new Thread(saveTask);
        saveThread.start();

        // Ожидаем завершения потока (опционально)
        try {
            saveThread.join(); // Ждём завершения потока
        } catch (InterruptedException e) {
            System.err.println("✗ Поток был прерван: " + e.getMessage());
        }
    }

    /**
     * Загрузка данных из файла через отдельный поток
     */
    private static void loadFromFile() {
        // Создаём задачу для загрузки
        FileLoadTask loadTask = new FileLoadTask(FILENAME, manager);
        
        // Создаём и запускаем поток
        Thread loadThread = new Thread(loadTask);
        loadThread.start();

        // Ожидаем завершения потока
        try {
            loadThread.join(); // Ждём завершения потока
        } catch (InterruptedException e) {
            System.err.println("✗ Поток был прерван: " + e.getMessage());
        }
    }
}
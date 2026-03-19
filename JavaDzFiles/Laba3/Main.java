// Главный класс — точка входа в программу
public class Main {

    public static void main(String[] args) {

        // Создаём компанию (максимум 10 сотрудников)
        Company company = new Company("ТехноСофт", 10);

        // Создаём сотрудников разных типов
        Manager manager1   = new Manager("Алексей Иванов", 35, 80000, 20000);
        Manager manager2   = new Manager("Ольга Смирнова", 42, 90000, 30000);
        Developer dev1     = new Developer("Дмитрий Козлов", 28, 70000, 10);
        Developer dev2     = new Developer("Анна Петрова", 25, 65000, 5);
        Employee employee1 = new Employee("Сергей Фёдоров", 30, 50000); // обычный сотрудник

        // Добавляем всех в компанию
        System.out.println("--- Добавление сотрудников ---");
        company.addEmployee(manager1);
        company.addEmployee(manager2);
        company.addEmployee(dev1);
        company.addEmployee(dev2);
        company.addEmployee(employee1);

        // Выводим информацию о всех сотрудниках
        // Здесь демонстрируется ПОЛИМОРФИЗМ:
        // один метод getInfo() — разное поведение в зависимости от типа объекта
        company.printAllEmployees();

        // Считаем общую зарплату
        System.out.println("\n=== Расчёт зарплат ===");
        double total = company.getTotalSalary();
        System.out.println("Общий фонд оплаты труда: " + total + " руб.");

        // Находим самого высокооплачиваемого
        Employee best = company.getHighestPaidEmployee();
        if (best != null) {
            System.out.println("\nСамый высокооплачиваемый сотрудник:");
            System.out.println(best.getInfo());
        }

        // --- Демонстрация полиморфизма отдельно ---
        System.out.println("\n=== Демонстрация полиморфизма ===");
        // Массив базового типа Employee, но хранит разные объекты
        Employee[] people = new Employee[3];
        people[0] = new Employee("Иван", 22, 40000);
        people[1] = new Manager("Мария", 33, 60000, 15000);
        people[2] = new Developer("Павел", 27, 55000, 8);

        for (Employee e : people) {
            // Вызывается нужная версия calculateSalary() автоматически
            System.out.println(e.getName() + " -> зарплата: " + e.calculateSalary() + " руб.");
        }
    }
}

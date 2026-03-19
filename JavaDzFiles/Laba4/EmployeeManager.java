import java.util.ArrayList;

/**
 * Класс EmployeeManager управляет коллекцией сотрудников
 */
public class EmployeeManager {
    private ArrayList<Employee> employees;

    /**
     * Конструктор
     */
    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    /**
     * Добавление нового сотрудника
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("✓ Сотрудник успешно добавлен!");
    }

    /**
     * Вывод всех сотрудников
     */
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст.");
            return;
        }

        System.out.println("\n" + "=".repeat(100));
        System.out.println("СПИСОК ВСЕХ СОТРУДНИКОВ (всего: " + employees.size() + ")");
        System.out.println("=".repeat(100));
        
        int index = 1;
        for (Employee emp : employees) {
            System.out.printf("%3d. %s%n", index++, emp);
        }
        System.out.println("=".repeat(100) + "\n");
    }

    /**
     * Поиск сотрудника по ФИО
     */
    public void findEmployee(String fullName) {
        boolean found = false;
        
        System.out.println("\nРезультаты поиска:");
        System.out.println("-".repeat(100));
        
        for (Employee emp : employees) {
            if (emp.getFullName().toLowerCase().contains(fullName.toLowerCase())) {
                System.out.println(emp);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Сотрудник с таким ФИО не найден.");
        }
        System.out.println("-".repeat(100) + "\n");
    }

    /**
     * Получение коллекции для сохранения
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Установка коллекции (используется при загрузке из файла)
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Получение количества сотрудников
     */
    public int getEmployeeCount() {
        return employees.size();
    }

    /**
     * Очистка списка сотрудников
     */
    public void clearEmployees() {
        employees.clear();
    }
}

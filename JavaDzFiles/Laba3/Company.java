// Класс компании — управляет сотрудниками
public class Company {

    private String companyName;
    private Employee[] employees; // массив базового типа — важно для полиморфизма!
    private int count;            // текущее количество сотрудников

    public Company(String companyName, int maxEmployees) {
        this.companyName = companyName;
        this.employees = new Employee[maxEmployees];
        this.count = 0;
    }

    // Добавить сотрудника в массив
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Добавлен: " + emp.getName());
        } else {
            System.out.println("Нет свободных мест в компании!");
        }
    }

    // Вывести информацию о всех сотрудниках
    public void printAllEmployees() {
        System.out.println("\n=== Сотрудники компании «" + companyName + "» ===");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].getInfo()); // полиморфизм в действии!
        }
    }

    // Подсчёт общей зарплаты
    public double getTotalSalary() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += employees[i].calculateSalary(); // у каждого свой calculateSalary()
        }
        return total;
    }

    // Поиск сотрудника с максимальной зарплатой
    public Employee getHighestPaidEmployee() {
        if (count == 0) {
            return null;
        }

        Employee best = employees[0];
        for (int i = 1; i < count; i++) {
            if (employees[i].calculateSalary() > best.calculateSalary()) {
                best = employees[i];
            }
        }
        return best;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCount() {
        return count;
    }
}

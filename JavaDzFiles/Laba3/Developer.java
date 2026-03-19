// Разработчик — наследник Employee
public class Developer extends Employee {

    private int overtimeHours;              // переработанные часы
    private static final double OVERTIME_RATE = 500.0; // ставка за 1 час переработки

    public Developer(String name, int age, double baseSalary, int overtimeHours) {
        super(name, age, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    // Переопределение: зарплата = базовая + часы * ставка
    @Override
    public double calculateSalary() {
        return baseSalary + overtimeHours * OVERTIME_RATE;
    }

    @Override
    public String getInfo() {
        return "Разработчик: " + getName() +
               ", возраст: " + getAge() +
               ", базовая: " + baseSalary +
               ", переработка: " + overtimeHours + " ч. x " + OVERTIME_RATE +
               ", итого: " + calculateSalary() + " руб.";
    }
}

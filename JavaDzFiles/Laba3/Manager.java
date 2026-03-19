// Менеджер — наследник Employee
public class Manager extends Employee {

    private double bonus; // дополнительное поле — премия

    // Конструктор: передаём поля родителя через super()
    public Manager(String name, int age, double baseSalary, double bonus) {
        super(name, age, baseSalary); // вызов конструктора родительского класса
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    // Переопределение расчёта зарплаты
    @Override
    public double calculateSalary() {
        return baseSalary + bonus; // базовая + премия
    }

    // Переопределение метода getInfo
    @Override
    public String getInfo() {
        return "Менеджер: " + getName() +
               ", возраст: " + getAge() +
               ", базовая: " + baseSalary +
               ", премия: " + bonus +
               ", итого: " + calculateSalary() + " руб.";
    }
}

// Базовый класс — Сотрудник
public class Employee {

    // Поля закрыты (private), доступ только через методы
    private String name;
    private int age;
    protected double baseSalary; // protected — чтобы наследники могли использовать

    // Конструктор с параметрами
    public Employee(String name, int age, double baseSalary) {
        this.name = name;
        this.age = age;
        this.baseSalary = baseSalary;
    }

    // Геттеры — методы для получения значений полей
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Расчёт зарплаты — базовый вариант просто возвращает baseSalary
    public double calculateSalary() {
        return baseSalary;
    }

    // Информация о сотруднике
    public String getInfo() {
        return "Сотрудник: " + name +
               ", возраст: " + age +
               ", зарплата: " + calculateSalary() + " руб.";
    }
}

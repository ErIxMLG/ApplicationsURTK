/**
 * Класс Employee представляет сотрудника организации
 */
public class Employee {
    private String fullName;
    private int age;
    private String position;
    private double salary;

    /**
     * Конструктор с параметрами
     */
    public Employee(String fullName, int age, String position, double salary) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    // Геттеры
    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    // Сеттеры
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Метод для получения строки для записи в файл
     * Формат: ФИО;Возраст;Должность;Зарплата
     */
    public String toFileString() {
        return fullName + ";" + age + ";" + position + ";" + salary;
    }

    /**
     * Метод для создания объекта из строки файла
     */
    public static Employee fromFileString(String line) throws IllegalArgumentException {
        String[] parts = line.split(";");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Неверный формат строки");
        }
        
        String fullName = parts[0];
        int age = Integer.parseInt(parts[1]);
        String position = parts[2];
        double salary = Double.parseDouble(parts[3]);
        
        return new Employee(fullName, age, position, salary);
    }

    @Override
    public String toString() {
        return String.format("%-30s | Возраст: %-3d | Должность: %-20s | Зарплата: %.2f руб.",
                fullName, age, position, salary);
    }
}

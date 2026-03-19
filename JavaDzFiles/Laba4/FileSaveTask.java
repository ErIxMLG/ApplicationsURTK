import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс FileSaveTask реализует сохранение данных в файл в отдельном потоке
 */
public class FileSaveTask implements Runnable {
    private ArrayList<Employee> employees;
    private String filename;

    /**
     * Конструктор
     */
    public FileSaveTask(ArrayList<Employee> employees, String filename) {
        this.employees = employees;
        this.filename = filename;
    }

    @Override
    public void run() {
        System.out.println("\n[ПОТОК] Начало сохранения данных в файл '" + filename + "'...");
        
        // Используем try-with-resources для автоматического закрытия ресурсов
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            
            // Записываем каждого сотрудника в отдельную строку
            for (Employee emp : employees) {
                writer.write(emp.toFileString());
                writer.newLine();
            }

            System.out.println("[ПОТОК] ✓ Данные успешно сохранены!");
            System.out.println("[ПОТОК] Количество записей: " + employees.size());
            
        } catch (IOException e) {
            System.err.println("[ПОТОК] ✗ Ошибка при сохранении файла: " + e.getMessage());
        } finally {
            System.out.println("[ПОТОК] Завершение работы потока сохранения.\n");
        }
    }
}

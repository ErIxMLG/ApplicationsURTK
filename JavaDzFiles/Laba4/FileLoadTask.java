import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс FileLoadTask реализует загрузку данных из файла в отдельном потоке
 */
public class FileLoadTask implements Runnable {
    private String filename;
    private EmployeeManager manager;

    /**
     * Конструктор
     */
    public FileLoadTask(String filename, EmployeeManager manager) {
        this.filename = filename;
        this.manager = manager;
    }

    @Override
    public void run() {
        System.out.println("\n[ПОТОК] Начало загрузки данных из файла '" + filename + "'...");
        
        ArrayList<Employee> loadedEmployees = new ArrayList<>();
        int successCount = 0;
        int errorCount = 0;
        
        // Используем try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Employee emp = Employee.fromFileString(line);
                    loadedEmployees.add(emp);
                    successCount++;
                } catch (IllegalArgumentException e) {
                    System.err.println("[ПОТОК] Ошибка чтения строки: " + line);
                    errorCount++;
                }
            }
            
            // Очищаем текущий список и добавляем загруженных сотрудников
            manager.clearEmployees();
            for (Employee emp : loadedEmployees) {
                manager.getEmployees().add(emp);
            }
            
            System.out.println("[ПОТОК] ✓ Данные успешно загружены!");
            System.out.println("[ПОТОК] Загружено записей: " + successCount);
            if (errorCount > 0) {
                System.out.println("[ПОТОК] Ошибок при чтении: " + errorCount);
            }
            
        } catch (IOException e) {
            System.err.println("[ПОТОК] ✗ Ошибка при загрузке файла: " + e.getMessage());
            System.err.println("[ПОТОК] Проверьте, существует ли файл '" + filename + "'");
        } finally {
            System.out.println("[ПОТОК] Завершение работы потока загрузки.\n");
        }
    }
}

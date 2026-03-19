import java.util.ArrayList;
import java.io.*;

// Класс бизнес-логики (собственный класс #2)
// Логика вынесена из GUI — хранение, файлы
public class TaskStore {

    private ArrayList<Task> tasks = new ArrayList<>();
    private static final String FILE = "C:\\Users\\ErL\\Desktop\\vscode\\JavaDZ\\Laba5\\tasks.txt";

    public void add(Task task) {
        tasks.add(task);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public ArrayList<Task> getAll() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }

    // Сохранение в файл
    public void saveToFile() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Task t : tasks) {
                pw.println(t.toLine());
            }
        }
    }

    // Загрузка из файла
    public void loadFromFile() throws IOException {
        File f = new File(FILE);
        if (!f.exists()) return;
        tasks.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        tasks.add(Task.fromLine(line)); // NumberFormatException если файл повреждён
                    } catch (NumberFormatException e) {
                        System.err.println("Пропущена строка: " + line);
                    }
                }
            }
        }
    }
}

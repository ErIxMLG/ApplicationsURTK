// Класс-модель задачи (собственный класс #1)
public class Task {

    private String title;
    private int priority; // 1, 2 или 3

    public Task(String title, int priority) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым!"); // пользовательская ошибка
        }
        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException("Приоритет должен быть от 1 до 3!");
        }
        this.title = title.trim();
        this.priority = priority;
    }

    public String getTitle()    { return title; }
    public int getPriority()    { return priority; }

    // Для сохранения в файл
    public String toLine() {
        return title + ";" + priority;
    }

    // Для загрузки из файла
    public static Task fromLine(String line) {
        String[] parts = line.split(";");
        int priority = Integer.parseInt(parts[1]); // может бросить NumberFormatException
        return new Task(parts[0], priority);
    }

    @Override
    public String toString() {
        return "[" + priority + "] " + title;
    }
}

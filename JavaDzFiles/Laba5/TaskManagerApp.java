import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class TaskManagerApp extends JFrame {

    private TaskStore store = new TaskStore();

    private DefaultListModel<Task> listModel = new DefaultListModel<>();
    private JList<Task> taskList = new JList<>(listModel);

    private JTextField tfTitle    = new JTextField();
    private JTextField tfPriority = new JTextField("1");  // сюда вводят число — нужен NumberFormatException
    private JTextArea  taLog      = new JTextArea(5, 1);
    private JLabel     lblCount   = new JLabel("Задач: 0");

    public TaskManagerApp() {
        setTitle("Менеджер задач");
        setSize(650, 450);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        // Автосохранение при закрытии (требование 4.5)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    store.saveToFile();
                    log("Данные сохранены.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка сохранения: " + ex.getMessage());
                }
                System.exit(0);
            }
        });

        // Загрузка при старте (требование 4.5)
        try {
            store.loadFromFile();
            for (Task t : store.getAll()) listModel.addElement(t);
            updateCount();
        } catch (IOException e) {
            log("Файл не найден, начинаем с нуля.");
        }

        buildUI();
    }

    private void buildUI() {
        // ===== ПАНЕЛЬ 1: ввод новой задачи =====
        JPanel inputPanel = new JPanel(new GridLayout(6, 1, 4, 4));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Добавить задачу"));
        inputPanel.add(new JLabel("Название:"));
        inputPanel.add(tfTitle);
        inputPanel.add(new JLabel("Приоритет (1-3):"));
        inputPanel.add(tfPriority);

        JButton btnAdd = new JButton("Добавить");       // кнопка 1
        JButton btnDelete = new JButton("Удалить");     // кнопка 2
        inputPanel.add(btnAdd);
        inputPanel.add(btnDelete);

        // ===== ПАНЕЛЬ 2: список + лог =====
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));
        listPanel.setBorder(BorderFactory.createTitledBorder("Список задач"));

        listPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        taLog.setEditable(false);
        taLog.setBackground(new Color(240, 240, 240));
        JPanel bottom = new JPanel(new BorderLayout(5, 5));
        bottom.add(lblCount, BorderLayout.WEST);

        JButton btnSave = new JButton("Сохранить в файл"); // кнопка 3
        bottom.add(btnSave, BorderLayout.EAST);
        bottom.add(new JScrollPane(taLog), BorderLayout.CENTER);
        listPanel.add(bottom, BorderLayout.SOUTH);

        // ===== Главный макет =====
        setLayout(new GridLayout(1, 2, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        add(inputPanel);
        add(listPanel);

        // ===== Обработчики =====

        // Добавить задачу
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            try {
                int priority = Integer.parseInt(tfPriority.getText().trim()); // NumberFormatException
                Task task = new Task(title, priority); // IllegalArgumentException
                store.add(task);
                listModel.addElement(task);
                tfTitle.setText("");
                tfPriority.setText("1");
                updateCount();
                log("Добавлено: " + task);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Приоритет должен быть числом (1, 2 или 3)!",
                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Удалить выбранную
        btnDelete.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index < 0) {
                JOptionPane.showMessageDialog(this,
                    "Выберите задачу для удаления!",
                    "Ничего не выбрано", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Task removed = store.get(index);
            store.remove(index);
            listModel.remove(index);
            updateCount();
            log("Удалено: " + removed);
        });

        // Сохранить вручную
        btnSave.addActionListener(e -> {
            try {
                store.saveToFile();
                JOptionPane.showMessageDialog(this,
                    "Файл tasks.txt сохранён!",
                    "Готово", JOptionPane.INFORMATION_MESSAGE);
                log("Файл сохранён.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                    "Ошибка при сохранении:\n" + ex.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void updateCount() {
        lblCount.setText("Задач: " + store.size());
    }

    private void log(String msg) {
        taLog.append(msg + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerApp().setVisible(true));
    }
}

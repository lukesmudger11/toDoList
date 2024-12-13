import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToDoList {
    private ArrayList<Task> tasks;

    // Constructor
    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(String taskName) {
        Task newTask = new Task(taskName);
        tasks.add(newTask);
        System.out.println("\nTask added: " + taskName);
    }

    // Method to display all tasks
    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks in the list. ");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ") " + tasks.get(i));
            }
        }
    }

    // Method to mark a task as complete
    public void completeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).completeTask();
            System.out.println("\nTask marked as completed. ");
        } else {
            System.out.println("\nInvalid task number. ");
        }
    }

    // Method to remove a task
    public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            System.out.println("\nTask removed: " + tasks.get(taskIndex).getName());
            tasks.remove(taskIndex);
        } else {
            System.out.println("\nInvalid task number. ");
        }
    }

    // Save tasks to a file
    public void saveTasksToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Task task : tasks) {
                writer.write(task.getName() + "," + task.isCompleted() + "\n");
            }
            System.out.println("Tasks saved to file. ");
        } catch (IOException e) {
            System.out.println("An error has occured while saving tasks. ");
        }
    }

    // Load tasks from a file
    public void loadTasksFromFile(String fileName) {
        tasks.clear(); // Clear current list before loading
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String taskName = parts[0];
                    boolean isCompleted = Boolean.parseBoolean(parts[1]);
                    Task task = new Task(taskName);
                    if (isCompleted) {
                        task.completeTask();
                    }
                    tasks.add(task);
                }
            }
            System.out.println("Tasks loaded from file. ");
        } catch (IOException e) {
            System.out.println("An error has occured while loading tasks. ");
        }
    }
}

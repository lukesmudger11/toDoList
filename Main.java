import java.util.*;

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Complete a task");
            System.out.println("4. Remove a task");
            System.out.println("5. Save tasks to file");
            System.out.println("6. Load tasks from file");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter task name: ");
                    String taskName = scanner.nextLine();
                    toDoList.addTask(taskName);
                    break;

                case 2:
                    toDoList.showTasks();
                    break;

                case 3:
                    toDoList.showTasks();
                    System.out.print("\nEnter task number to complete: ");
                    int taskIndexToComplete = scanner.nextInt() - 1;
                    toDoList.completeTask(taskIndexToComplete);
                    break;

                case 4:
                    toDoList.showTasks();
                    System.out.print("\nEnter task number to remove: ");
                    int taskIndexToRemove = scanner.nextInt() - 1;
                    toDoList.removeTask(taskIndexToRemove);
                    break;

                case 5:
                    System.out.println("Enter filename to save tasks: ");
                    String saveFileName = scanner.nextLine();
                    toDoList.saveTasksToFile(saveFileName);
                    break;

                case 6:
                    System.out.println("Enter filename to load tasks: ");
                    String loadFileName = scanner.nextLine();
                    toDoList.loadTasksFromFile(loadFileName);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid option. Please try again. ");
            }
        }

        scanner.close();
    }
}

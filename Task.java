public class Task {
    private String name;
    private boolean isCompleted;

    // Constructor
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    // Getter for task name
    public String getName() {
        return name;
    }

    // Method to mark a task as completed
    public void completeTask() {
        this.isCompleted = true;
    }

    // Check if a task is completed
    public boolean isCompleted() {
        return isCompleted;
    }

    // Override toString for easy task representation
    @Override
    public String toString() {
        return (isCompleted ? "[Completed]" : "[Pending]") + name;
    }
}

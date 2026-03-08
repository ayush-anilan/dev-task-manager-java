package main.java.com.ayush.taskmanager.util;

import java.util.Scanner;

import main.java.com.ayush.taskmanager.enums.Priority;
import main.java.com.ayush.taskmanager.enums.TaskStatus;
import main.java.com.ayush.taskmanager.model.Task;
import main.java.com.ayush.taskmanager.service.TaskService;

public class InputUtil {
    
    public static void createTask(Scanner scanner, TaskService taskService) {
        int id = IdGenerator.generateId();
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task priority (LOW, MEDIUM, HIGH): ");
        Priority priorityInput = Priority.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter task status (TODO, IN_PROGRESS, DONE): ");
        TaskStatus taskInput = TaskStatus.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("====================================");

        // Create and save the task using TaskService
        Task task = new Task(id, title, description, priorityInput, taskInput);
        taskService.createTask(task);
        System.out.println("Task created successfully!");
        System.out.println("====================================");
    }

    public static void viewAllTasks(TaskService taskService) {
        System.out.println("All Tasks:");
        System.out.println("====================================");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task.getId() + ": " + task.getTitle() + " - " + task.getDescription() + " [" + task.getPriority() + "]" + " [" + task.getStatus() + "]");
        }
        System.out.println("====================================");
    }

public static void updateTask(Scanner scanner, TaskService taskService) {

    if (taskService.getAllTasks().isEmpty()) {
        System.out.println("No tasks available to update.");
        return;
    }

    System.out.println("Available Tasks:");
    System.out.println("====================================");

    for (Task task : taskService.getAllTasks()) {
        System.out.println(task.getId() + " - " + task.getTitle());
    }
    System.out.println("====================================");

    System.out.print("Enter task ID to update: ");
    int taskId = scanner.nextInt();
    scanner.nextLine();

    Task existingTask = taskService.getTaskById(taskId);

    if (existingTask == null) {
        System.out.println("Task not found.");
        return;
    }

    System.out.print("Enter new title (leave blank to keep current): ");
    String title = scanner.nextLine();

    if (!title.isEmpty()) {
        existingTask.setTitle(title);
    }

    System.out.print("Enter new description (leave blank to keep current): ");
    String description = scanner.nextLine();

    if (!description.isEmpty()) {
        existingTask.setDescription(description);
    }

    System.out.print("Enter new priority (LOW, MEDIUM, HIGH) or blank: ");
    String priorityInput = scanner.nextLine();

    if (!priorityInput.isEmpty()) {
        Priority newPriority = Priority.valueOf(priorityInput.toUpperCase());
        existingTask.setPriority(newPriority);
    }

    System.out.print("Enter new status (TODO, IN_PROGRESS, DONE) or blank: ");
    String statusInput = scanner.nextLine();

    if (!statusInput.isEmpty()) {
        TaskStatus newStatus = TaskStatus.valueOf(statusInput.toUpperCase());
        existingTask.setStatus(newStatus);
    }
    System.out.println("====================================");

    taskService.updateTask(existingTask);

    System.out.println("Task updated successfully!");
    System.out.println("====================================");
}

public static void deleteTask(Scanner scanner, TaskService taskService) {

    if (taskService.getAllTasks().isEmpty()) {
        System.out.println("No tasks available.");
        return;
    }

    System.out.println("Available Tasks:");

    for (Task task : taskService.getAllTasks()) {
        System.out.println(task.getId() + " - " + task.getTitle());
    }

    System.out.println("====================================");

    System.out.print("Enter task ID to delete: ");
    int taskId = scanner.nextInt();
    scanner.nextLine();

    System.out.println("====================================");

    taskService.deleteTask(taskId);

    System.out.println("Task deleted successfully!");
            System.out.println("====================================");
}

public static void viewTasksByPriority(Scanner scanner, TaskService taskService) {                    
    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
    System.out.println("====================================");
    Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
    System.out.println("Tasks with " + priority + " priority:");
    for (Task task : taskService.getTasksByPriority(priority)) {
        System.out.println(task.getId() + ": " + task.getTitle() + " - " + task.getDescription());
    }
    System.out.println("====================================");
}

public static void viewTasksByStatus(Scanner scanner, TaskService taskService){
    System.out.print("Enter status (TODO, IN_PROGRESS, DONE): ");
    System.out.println("====================================");
    TaskStatus status = TaskStatus.valueOf(scanner.nextLine().toUpperCase());
    System.out.println("Tasks with " + status + " status:");
    for(Task task: taskService.getTasksByStatus(status)){
        System.out.println(task.getId() + ": " + task.getTitle() + " - " + task.getDescription());
    }
    System.out.println("====================================");
}

}

package main.java.com.ayush.taskmanager.util;

import java.util.Scanner;

import main.java.com.ayush.taskmanager.enums.Priority;
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

        // Create and save the task using TaskService
        Task task = new Task(id, title, description, priorityInput);
        taskService.createTask(task);
        System.out.println("Task created successfully!");
    }

    public static void viewAllTasks(TaskService taskService) {
        System.out.println("All Tasks:");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task.getId() + ": " + task.getTitle() + " - " + task.getDescription() + " [" + task.getPriority() + "]");
        }
    }

public static void updateTask(Scanner scanner, TaskService taskService) {

    if (taskService.getAllTasks().isEmpty()) {
        System.out.println("No tasks available to update.");
        return;
    }

    System.out.println("Available Tasks:");

    for (Task task : taskService.getAllTasks()) {
        System.out.println(task.getId() + " - " + task.getTitle());
    }

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

    taskService.updateTask(existingTask);

    System.out.println("Task updated successfully!");
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

    System.out.print("Enter task ID to delete: ");
    int taskId = scanner.nextInt();
    scanner.nextLine();

    taskService.deleteTask(taskId);

    System.out.println("Task deleted successfully!");
}
}

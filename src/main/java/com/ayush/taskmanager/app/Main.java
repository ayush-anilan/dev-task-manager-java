package com.ayush.taskmanager.app;

import main.java.com.ayush.taskmanager.service.TaskService;
import main.java.com.ayush.taskmanager.model.Task;
import main.java.com.ayush.taskmanager.enums.Priority;
import main.java.com.ayush.taskmanager.enums.TaskStatus;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Task Manager!");
        TaskService taskService = new TaskService();
        // Create some tasks
        Task task1 = new Task(1, "Buy groceries", "Milk, Bread, Eggs", Priority.HIGH);
        Task task2 = new Task(2, "Finish project", "Complete the Java project by Friday", Priority.MEDIUM, TaskStatus.IN_PROGRESS);
        taskService.createTask(task1);
        taskService.createTask(task2);
        // Print all tasks  
        System.out.println("All Tasks:");
        for (Task task : taskService.getAllTasks()) {
            System.out.println(task.getId() + ": " + task.getTitle() + " - " + task.getStatus() + " - " + task.getPriority() + " - Created At: " + task.getCreatedAt());
        }
        
    }
}
package com.ayush.taskmanager.app;

import main.java.com.ayush.taskmanager.service.TaskService;
import main.java.com.ayush.taskmanager.util.InputUtil;
import main.java.com.ayush.taskmanager.model.Task;

import java.util.Scanner;

import main.java.com.ayush.taskmanager.enums.Priority;
import main.java.com.ayush.taskmanager.enums.TaskStatus;


public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. View Tasks by Priority");
            System.out.println("6. View Tasks by Status");
            System.out.println("7. Exit");
            System.out.println("====================================");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("====================================");

            switch (choice) {
                case 1:
                    InputUtil.createTask(scanner, taskService);
                    break;

                case 2:
                    InputUtil.viewAllTasks(taskService);
                    break;

                case 3:
                    InputUtil.updateTask(scanner, taskService);
                    break;

                case 4:
                    InputUtil.deleteTask(scanner, taskService);
                    break;

                case 5:
                    InputUtil.viewTasksByPriority(scanner, taskService);
                    break;

                case 6:
                    InputUtil.viewTasksByStatus(scanner, taskService);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
    }
}
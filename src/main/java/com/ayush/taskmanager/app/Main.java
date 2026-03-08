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
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
    }
}
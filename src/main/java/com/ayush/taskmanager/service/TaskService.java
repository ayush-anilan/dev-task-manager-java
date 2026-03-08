package main.java.com.ayush.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.ayush.taskmanager.model.Task;
import main.java.com.ayush.taskmanager.enums.Priority;
import main.java.com.ayush.taskmanager.enums.TaskStatus;
import main.java.com.ayush.taskmanager.repository.TaskRepository;

public class TaskService {
    
    private TaskRepository taskRepository;
    
    public TaskService() {
        this.taskRepository = new TaskRepository();
    }
    
    public void createTask(Task task) {
        taskRepository.addTask(task);
    }

    public void updateTask(Task updatedTask) {
        taskRepository.updateTask(updatedTask);
    }

    public void deleteTask(int taskId) {
        taskRepository.removeTask(taskId);
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(int taskId) {
        return taskRepository.getTaskById(taskId);
    }

    public List<Task> getTasksByPriority(Priority priority) {
        return taskRepository.getTasksByPriority(priority);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTasksByStatus(status);
    }
}

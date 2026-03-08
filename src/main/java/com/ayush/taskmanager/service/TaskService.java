package main.java.com.ayush.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.ayush.taskmanager.model.Task;

public class TaskService {
    
    private List<Task> tasks;
    
    public TaskService() {
        this.tasks = new ArrayList<>();
    }
    
    public void createTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == updatedTask.getId()) {
                tasks.set(i, updatedTask);
                return;
            }
        }
    }

    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }
    
    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }
}

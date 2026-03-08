package main.java.com.ayush.taskmanager.repository;

import java.util.ArrayList;
import java.util.List;

import main.java.com.ayush.taskmanager.model.Task;

public class TaskRepository {
    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    
    public void updateTask(Task updatedTask) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == updatedTask.getId()) {
                taskList.set(i, updatedTask);
                return;
            }
        }
    }

    public void removeTask(int taskId) {
        taskList.removeIf(task -> task.getId() == taskId);
    }

    public List<Task> getAllTasks() {
        return taskList;
    }   

    public Task getTaskById(int taskId) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

}

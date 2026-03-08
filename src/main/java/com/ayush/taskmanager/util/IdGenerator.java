package main.java.com.ayush.taskmanager.util;

public class IdGenerator {
    private static int currentId = 0;

    public static synchronized int generateId() {
        return ++currentId;
    }
}

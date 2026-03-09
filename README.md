# Task Manager (Java)

A console-based task management application built with Java. This application allows users to create, view, update, and delete tasks with priority levels and status tracking.

## Features

- ✅ **Create Tasks**: Add new tasks with title, description, and priority
- 📋 **View All Tasks**: Display all tasks in the system
- ✏️ **Update Tasks**: Modify existing task details including status and priority
- 🗑️ **Delete Tasks**: Remove tasks from the system
- 🎯 **Filter by Priority**: View tasks filtered by LOW, MEDIUM, or HIGH priority
- 📊 **Filter by Status**: View tasks filtered by TODO, IN_PROGRESS, or DONE status
- ⏰ **Auto-Timestamps**: Automatic tracking of creation and update times

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd dev-task-manager-java
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

## Running the Application

Run the application using Maven:

```bash
mvn exec:java
```

Or compile and run directly:

```bash
mvn clean package
java -cp target/classes com.ayush.taskmanager.app.Main
```

## Usage

When you run the application, you'll see a menu with the following options:

```
1. Create Task
2. View All Tasks
3. Update Task
4. Delete Task
5. View Tasks by Priority
6. View Tasks by Status
7. Exit
```

### Creating a Task
- Select option 1
- Enter task title, description, and priority (LOW, MEDIUM, HIGH)
- Task will be created with default status: TODO

### Updating a Task
- Select option 3
- Enter the task ID you want to update
- Provide new title, description, priority, and status

### Filtering Tasks
- **By Priority**: Select option 5 and choose from LOW, MEDIUM, or HIGH
- **By Status**: Select option 6 and choose from TODO, IN_PROGRESS, or DONE

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── ayush/
│   │           └── taskmanager/
│   │               ├── app/
│   │               │   └── Main.java           # Application entry point
│   │               ├── enums/
│   │               │   ├── Priority.java       # Priority levels
│   │               │   └── TaskStatus.java     # Task statuses
│   │               ├── model/
│   │               │   └── Task.java           # Task entity
│   │               ├── repository/
│   │               │   └── TaskRepository.java # Data access layer
│   │               ├── service/
│   │               │   └── TaskService.java    # Business logic layer
│   │               └── util/
│   │                   ├── IdGenerator.java    # ID generation utility
│   │                   └── InputUtil.java      # Input handling utility
│   └── resources/
└── test/
    └── java/
```

## Architecture

The application follows a layered architecture:

- **Model Layer**: Defines the Task entity with all properties
- **Repository Layer**: Handles in-memory data storage and retrieval
- **Service Layer**: Contains business logic for task operations
- **Utility Layer**: Helper classes for ID generation and user input handling
- **Application Layer**: Main entry point with console UI

## Technologies Used

- **Java 17**: Core programming language
- **Maven**: Build and dependency management
- **Java Time API**: For timestamp management

## Task Properties

Each task contains:
- `id`: Unique identifier (auto-generated)
- `title`: Task title
- `description`: Detailed description
- `priority`: LOW, MEDIUM, or HIGH
- `status`: TODO, IN_PROGRESS, or DONE
- `createdAt`: Timestamp of creation
- `updatedAt`: Timestamp of last update

## Future Enhancements

- [ ] Persist tasks to a database or file
- [ ] Add due dates and reminders
- [ ] Implement task search functionality
- [ ] Add user authentication
- [ ] Create a GUI version
- [ ] Migrate to Spring Boot REST API
- [ ] Add task categories/tags

## Author

Ayush

## License

This project is open source and available for educational purposes.

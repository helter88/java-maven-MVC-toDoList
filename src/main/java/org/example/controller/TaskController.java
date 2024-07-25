package org.example.controller;

import org.example.model.Task;
import org.example.model.TaskList;
import org.example.view.ConsoleView;

public class TaskController {
    private TaskList tasks; //TODO: Task + TaskRepository (CRUD) - storage
    private ConsoleView view;

    public TaskController(ConsoleView view) {
        this.tasks = new TaskList();
        this.view = view;
    }

    public void run() {
        var finish = "1";
        do {
            performOperation(chooseOperation());
            finish = chooseToFinishProgram();
        } while (!finish.equals("0"));

    }

    private void performOperation(String operation) {
        switch (operation) {
            case "1" -> addTaskToList();
            case "2" -> displayTasks();
            case "3" -> updateTask();
            case "4" -> deleteTask();
            default -> view.print("Invalid operation: " + operation);
        }
    }

    private void deleteTask() {
        view.print("Write task title to delete");
        var taskTitleToDelete = view.getString();
       if(!tasks.checkIfTitlePresent(taskTitleToDelete)) {
           view.print("Task title: " + taskTitleToDelete + " doesn't exist");
       } else {
           tasks.deleteTask(taskTitleToDelete);
       }
    }

    private void addTaskToList() {
        view.print("Create Task: " );
        try {
            view.print("Write task title: ");
            var title = view.getString();
            view.print("Write task description: ");
            var description = view.getString();
            view.print("Is done? ");
            boolean isDone = view.getBoolean();
            var newTask = new Task(title, description, isDone);
            tasks.addNewTask(newTask);
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid operation");
        }

    }

    private void displayTasks() {
        view.print(tasks.getTasks().toString());
    }

    private void updateTask() {
        view.print("Write task name to update");
        var taskTitleToUpdate =  view.getString();
        if(!tasks.checkIfTitlePresent(taskTitleToUpdate)) {
            view.print("task title: " + taskTitleToUpdate + " doesn't exist");
        } else {
            view.print("Choose one from options: ");
            view.print("1 task title");
            view.print("2 task description");
            view.print("3 finish task");
            view.print("Insert value (1 or 2 or 3): ");
            var option = view.getString(); //chooseValidUpdateOption();
            switch (option) {
                case "1" -> updateTaskTitle(taskTitleToUpdate);
                case "2" -> updateTaskDescription(taskTitleToUpdate);
                case "3" -> completeTask(taskTitleToUpdate);
                default -> view.print("Invalid operation: " + option);
            }
        }

    }

    private void completeTask(String taskTitleToUpdate) {
        tasks.completeTask(taskTitleToUpdate);
    }

    private void updateTaskDescription(String taskTitleToUpdate) {
        view.print("Write new description: ");
        String newDescription = view.getString();
        tasks.updateTaskDescription(taskTitleToUpdate, newDescription);
    }

    private void updateTaskTitle(String taskTitleToUpdate) {
        view.print("Write new title: ");
        var newTaskTitle = view.getString();
        tasks.updateTaskTile(taskTitleToUpdate, newTaskTitle);
    }


    public String chooseOperation(){
        view.print("Which operation would you like to perform?");
        view.print("1 add task to taskList");
        view.print("2 display task list");
        view.print("3 update task");
        view.print("4 delete task");
        view.print("Insert value (1 or 2 or 3 or 4): ");
        return view.getString();
    }
    public String chooseToFinishProgram() {
        view.print("Press 0 to finish or other number to continue");
        return view.getString();
    }

}

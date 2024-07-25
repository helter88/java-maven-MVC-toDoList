package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addNewTask(Task newTask){
        tasks.add(newTask);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean checkIfTitlePresent(String taskTitle){
        return tasks.stream().anyMatch( task -> task.title().equals(taskTitle));
    }

    public void updateTaskTile(String taskTitleToUpdate, String newTaskTitle){
        tasks = tasks.stream().map(task ->
                task.title().equals(taskTitleToUpdate) ?
                new Task(newTaskTitle, task.description(), task.isDone()) :
                task).toList();
    }

    public void updateTaskDescription(String taskTitleToUpdate, String newTaskDescription){
        tasks = tasks.stream().map(task ->
                task.title().equals(taskTitleToUpdate) ? new Task(task.title(), newTaskDescription, task.isDone())
                        : task).toList();
    }

    public void completeTask(String taskTitleToUpdate){
        tasks = tasks.stream().map(task ->
                task.title().equals(taskTitleToUpdate) ? new Task(task.title(), task.description(), !task.isDone())
                        : task).toList();
    }
    public void deleteTask(String taskTitleToDelete){
        tasks = tasks.stream().filter(task -> !task.title().equals(taskTitleToDelete)).toList();
    }


}

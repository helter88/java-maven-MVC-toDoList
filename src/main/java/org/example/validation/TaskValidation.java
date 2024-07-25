package org.example.validation;

import org.example.model.Task;

import java.util.List;

public class TaskValidation {

    public static boolean isPresent(List<Task> tasks, String taskTitle){
        return tasks.stream()
                .anyMatch(task -> task.title().equals(taskTitle));
    }
}

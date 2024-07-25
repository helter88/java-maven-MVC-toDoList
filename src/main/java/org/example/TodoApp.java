package org.example;

import org.example.controller.TaskController;
import org.example.view.ConsoleView;

public class TodoApp {
    public static void main(String[] args) {
        var controller = new TaskController(new ConsoleView());
        controller.run();
    }
}
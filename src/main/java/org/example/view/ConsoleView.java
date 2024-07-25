package org.example.view;

import org.example.model.Task;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    Scanner sc = new Scanner(System.in);
    public String getString() {
        return sc.nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }

    public boolean getBoolean() {
        while (true) {
            print("Write 'true' lub 'false':");
            String input = sc.nextLine().toLowerCase().trim();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                print("Invalid value. Please try again");
            }
        }
    }
}

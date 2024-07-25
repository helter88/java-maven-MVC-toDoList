package org.example.validation;

import static org.example.utils.InputParsing.unifyInput;

public class InputValidation {
    public static boolean isBooleanValid(String input){
        String trimmedInput = unifyInput(input);
        return trimmedInput.equals("true") || trimmedInput.equals("false");
    }

    public static boolean isValidTask(String input){
        String trimmedInput = unifyInput(input);
        var regex = "[1-4]{1}";
        return trimmedInput.matches(regex);
    }

    public static boolean isValidUpdateTask(String input) {
        String trimmedInput = unifyInput(input);
        var regex ="[1-3]{1}";
        return trimmedInput.matches(regex);
    }

    public static boolean isNumber(String input){
        String trimmedInput = unifyInput(input);
        var regex ="\\d{1}";
        return trimmedInput.matches(regex);
    }
}

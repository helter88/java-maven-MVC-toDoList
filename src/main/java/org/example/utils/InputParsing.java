package org.example.utils;

public class InputParsing {
    public static String unifyInput(String input){
        return input.trim().toLowerCase();
    }

    public static boolean parseStringToBoolean(String input){
        var unifiedInput = unifyInput(input);
        return switch (unifiedInput){
            case "true" -> true;
            default -> false;
        };
    }
}

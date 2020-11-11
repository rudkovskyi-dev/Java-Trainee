package dev.rudkovskyi.mvc.controller;

import dev.rudkovskyi.mvc.view.View;

import java.util.Scanner;

public class Utility {
    private Scanner scanner;
    private View view;

    public Utility(Scanner scanner, View view){
        this.scanner = scanner;
        this.view = view;
    }

    // The Utility methods

    /**
     * Shows the parameter message and returns the input with compliance to the provided regex pattern
     * @param message the string from the resource bundle set to display
     * @param pattern the string of the regex pattern to follow
     * @return the string provided by user
     */
    String inputStringWithRegex(String message, String pattern){
        String result;
        view.printInput(message);
        while (!scanner.hasNext() || !(result = scanner.next()).matches(pattern)){
            view.printWrongInfo(message);
        }
        return result;
    }
}

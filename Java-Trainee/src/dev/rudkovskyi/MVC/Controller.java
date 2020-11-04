package dev.rudkovskyi.MVC;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private final Model model;
    private final View view;

    // Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setSecretValue();
        boolean numberIsGuessed = false;

        while(!numberIsGuessed){
            int guessedNumber = inputIntValueWithinTheRangeWithScanner(sc);
            numberIsGuessed = model.checkGuess(guessedNumber);
            view.printMessage(View.YOUR_GUESS_WAS + guessedNumber);

            if (numberIsGuessed){
                view.printMessage(View.CORRECT_ANSWER);
            }
            else {
                if (model.isSecretNumberSmallerThanGuess(guessedNumber)){
                    view.printMessage(View.THE_ANSWER_IS_SMALLER);
                }
                else {
                    view.printMessage(View.THE_ANSWER_IS_BIGGER);
                }
            }
        }

        printAttempts(model.getStatistics());
    }

    // The Utility methods
    public int inputIntValueWithinTheRangeWithScanner(Scanner sc) {
        view.printRangeMessage(model.getLeftBorder(), model.getRightBorder());
        while(true){
            int guessedNumber = inputIntValueWithScanner(sc);
            if (model.isOutOfTheRange(guessedNumber)){
                view.printMessage(View.WRONG_INPUT_INT_DATA);
                view.printRangeMessage(model.getLeftBorder(), model.getRightBorder());
            } else {
                return guessedNumber;
            }
        }
    }

    public int inputIntValueWithScanner(Scanner sc) {
        while(!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            view.printRangeMessage(model.getLeftBorder(), model.getRightBorder());
            sc.next();
        }
        return sc.nextInt();
    }

    public void printAttempts(ArrayList<Integer> previousAttempts){
        String sequence = "";
        for (Integer value : previousAttempts){
            sequence += value + " ";
        }
        view.printMessage(View.YOUR_SEQUENCE_WAS + sequence);
    }
}

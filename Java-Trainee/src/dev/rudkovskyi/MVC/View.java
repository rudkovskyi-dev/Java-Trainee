package dev.rudkovskyi.MVC;

public class View {
    // Text's constants
    private static final String GUESS_NUMBER = "Guess the number between ";
    private static final String RANGE_AND = " and ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String THE_ANSWER_IS_SMALLER = "Almost there, try a smaller number";
    public static final String THE_ANSWER_IS_BIGGER = "Almost there, try a bigger number";
    public static final String CORRECT_ANSWER = "This is the correct number, well done!";
    public static final String YOUR_GUESS_WAS = "Your guess was = ";
    public static final String YOUR_SEQUENCE_WAS = "You guess sequence was = ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printRangeMessage(int leftBorder, int rightBorder) {
        System.out.println( GUESS_NUMBER + leftBorder + RANGE_AND + rightBorder);
    }
}
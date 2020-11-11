package dev.rudkovskyi.mvc.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static dev.rudkovskyi.mvc.view.StringConstant.WRONG_INFO;

public class View {

    public static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(
                    "messages",
                    new Locale("en")
                    //new Locale("ua", "UA")
            );

    /**
     * Prints the provided message
     * @param message the string that will be printed
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Concatenates several strings in one and returns the string result
     * @param message one or more strings that should be concatenated
     * @return returns the string result of concatenation
     */
    public String buildString(String... message){
        StringBuilder strBuilder = new StringBuilder();
        for (String item : message){
            strBuilder.append(item);
        }
        return strBuilder.toString();
    }

    /**
     * Prints provided message converting it to the currently set locale
     * @param message the string from the resource bundle set
     */
    public void printInput(String message) {
        printMessage(resourceBundle.getString(message));
    }

    /**
     * Prints wrong information message and provided message
     * converting them to the currently set locale
     * @param message the string from the resource bundle set
     */
    public void printWrongInfo(String message){
        printMessage(
                buildString(
                        resourceBundle.getString(WRONG_INFO),
                        resourceBundle.getString(message)
                )
        );
    }
}

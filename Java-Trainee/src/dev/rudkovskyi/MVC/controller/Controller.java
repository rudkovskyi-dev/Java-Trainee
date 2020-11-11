package dev.rudkovskyi.mvc.controller;

import dev.rudkovskyi.mvc.model.Model;
import dev.rudkovskyi.mvc.view.View;

import java.util.Scanner;

import static dev.rudkovskyi.mvc.controller.RegexPattern.*;
import static dev.rudkovskyi.mvc.view.StringConstant.*;

public class Controller {
    private final Model model;
    private final View view;

    private String name;
    private String nickName;
    private String phone;

    // Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner scanner = new Scanner(System.in);

        Utility utility = new Utility(scanner, view);
        String namePattern = REGEX_NAME;
        String locale = View.resourceBundle.getLocale().toString();
        if (locale.equals("ua")){
            namePattern = UA_REGEX_NAME;
        }

        this.name = utility.inputStringWithRegex(ENTER_NAME, namePattern);
        this.nickName = utility.inputStringWithRegex(ENTER_NICKNAME, REGEX_NICKNAME);
        this.phone = utility.inputStringWithRegex(ENTER_PHONE, REGEX_PHONE);

        scanner.close();
    }
}

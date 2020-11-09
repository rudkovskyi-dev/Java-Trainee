package dev.rudkovskyi.mvc;

import dev.rudkovskyi.mvc.controller.Controller;
import dev.rudkovskyi.mvc.model.Model;
import dev.rudkovskyi.mvc.view.View;

public class Main {
    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}

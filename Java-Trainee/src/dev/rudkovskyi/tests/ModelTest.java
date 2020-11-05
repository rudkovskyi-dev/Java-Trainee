package dev.rudkovskyi.tests;

import dev.rudkovskyi.mvc.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void setSecretValue() {
        Model model = new Model();
        int value = model.getSecretNumber();
        for (int attemptsToSet = 0; attemptsToSet < 10000; attemptsToSet++){
            model.setSecretValue();
            value = model.getSecretNumber();
            if (value < model.getLeftBorder())
                Assertions.fail("setSecretValue Test Failed (out of left border)");
            if (value > model.getRightBorder())
                Assertions.fail("setSecretValue Test Failed (out of right border)");
        }
    }

    @Test
    void checkGuess() {
        for (int attemptsToSet = 0; attemptsToSet < 10000; attemptsToSet++) {
            Model model = new Model();
            model.setSecretValue();
            int left = model.getLeftBorder();
            int right = model.getRightBorder();
            int range = right - left;
            int value = (int) (Math.random() * range + model.getLeftBorder());
            int statisticsCount = model.getStatistics().size();
            model.checkGuess(value);
            if (statisticsCount == model.getStatistics().size())
                Assertions.fail("CheckGuess - StatisticsUpdate Test Failed (No new values)");
            if (value != model.getSecretNumber()){
                if (!model.isSecretNumberSmallerThanGuess(value) && value >= model.getLeftBorder())
                    Assertions.fail("CheckGuess - UpdateBorders Test Failed (Left Border Update Failed)");
                if (model.isSecretNumberSmallerThanGuess(value) && value <= model.getRightBorder())
                    Assertions.fail("CheckGuess - UpdateBorders Test Failed (Right Border Update Failed)");
            }
            if (!model.checkGuess(model.getSecretNumber()))
                Assertions.fail("CheckGuess - Test Failed (Number Comparison Is Broken)");
        }
    }

    @Test
    void isSecretNumberSmallerThanGuess() {
        Model model = new Model();
        int value = model.getSecretNumber();
        if (model.isSecretNumberSmallerThanGuess(value)){
            Assertions.fail("IsSmaller Test Failed (equality)");
        }
        if (model.isSecretNumberSmallerThanGuess(value - 1)){
            Assertions.fail("IsSmaller Test Failed (bigger)");
        }
    }

    @Test
    void isOutOfTheRange() {
        Model model = new Model();
        for (int value = model.getLeftBorder(); value <= model.getRightBorder(); value++){
            if (model.isOutOfTheRange(value)){
                Assertions.fail("Range Test Failed");
            }
        }
    }

    @Test
    void isOutOfTheRangeLower() {
        Model model = new Model();
        int value = model.getLeftBorder() - 1;
        if (!model.isOutOfTheRange(value)) {
            Assertions.fail("Lower Range Test Failed");
        }
    }

    @Test
    void isOutOfTheRangeHigher() {
        Model model = new Model();
        int value = model.getRightBorder() + 1;
        if (!model.isOutOfTheRange(value)) {
            Assertions.fail("Higher Range Test Failed");
        }
    }
}
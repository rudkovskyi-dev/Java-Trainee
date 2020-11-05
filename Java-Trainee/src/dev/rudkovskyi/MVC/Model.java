package dev.rudkovskyi.mvc;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;
    private static final int STOCK_SECRET_VALUE = -1;

    private int secretNumber;
    private int leftBorder;
    private int rightBorder;
    private final ArrayList<Integer> statistics;

    public Model(){
        secretNumber = STOCK_SECRET_VALUE;
        statistics = new ArrayList<>();
        leftBorder = MIN_VALUE;
        rightBorder = MAX_VALUE;
    }

    public void setSecretValue(){
        int range = rightBorder - leftBorder;
        double random = Math.random() * range + leftBorder;
        this.secretNumber = (int)random;
    }

    public int getSecretNumber(){
        return secretNumber;
    }

    public int getLeftBorder(){
        return leftBorder;
    }

    public int getRightBorder(){
        return rightBorder;
    }

    public List<Integer> getStatistics(){
        return statistics;
    }

    public boolean checkGuess(int value){
        if (secretNumber == value){
            statistics.add(value);
            return true;
        }
        updateBorders(value);
        statistics.add(value);
        return false;
    }

    private void updateBorders(int value){
        if (secretNumber > value && leftBorder <= value){
            if (leftBorder == value){
                leftBorder++;
            } else {
                leftBorder = value + 1;
            }
        }
        if (secretNumber < value && rightBorder >= value){
            if (rightBorder == value) {
                rightBorder--;
            } else {
                rightBorder = value - 1;
            }
        }
    }

    public boolean isSecretNumberSmallerThanGuess(int value){
        return (secretNumber < value);
    }

    public boolean isOutOfTheRange(int value){
        return (value < leftBorder || value > rightBorder);
    }
}

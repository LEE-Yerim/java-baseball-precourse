package controller;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int NUMBER_OF_NUMBERS = 3;
    InputView inputView = new InputView();

    public void start() {
        List<Integer> userNumbers = createUserNumbers();
    }

    public List<Integer> createUserNumbers() {
        String userNumbers = inputView.inputNumbers();
        return convertUserNumbers(userNumbers);
    }

    public List<Integer> convertUserNumbers(String numbers) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            userNumbers.add(Character.getNumericValue(numbers.charAt(i)));
        }
        return userNumbers;
    }
}

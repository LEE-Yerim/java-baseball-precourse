package controller;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int NUMBER_OF_NUMBERS = 3;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        int newGame = 1;
        while (newGame == 1) {
            List<Integer> randomNumbers = createRandomNumbers();

            boolean newInput = true;
            while (newInput) {
                List<Integer> userNumbers = createUserNumbers();

                int strike = countStrike(randomNumbers, userNumbers);
                int ball = countBall(randomNumbers, userNumbers);

                outputView.outputStrikeBall(strike, ball);
                if (strike == 3) {
                    newInput = false;
                    newGame = inputView.inputNewGame();
                }
            }
        }
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            randomNumbers.add((int) (Math.random() * 9 + 1));
            for (int j = 0; j < i; j++) {
                if (randomNumbers.get(i) == randomNumbers.get(j)) {
                    i--;
                }
            }
        }
        return randomNumbers;
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

    public int countStrike(List<Integer> randomNumbers, List<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            for (int j = 0; j < NUMBER_OF_NUMBERS; j++) {
                if (randomNumbers.get(i) == userNumbers.get(j) && i == j)
                    strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> randomNumbers, List<Integer> userNumbers) {
        int ball = 0;
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            for (int j = 0; j < NUMBER_OF_NUMBERS; j++) {
                if (randomNumbers.get(i) == userNumbers.get(j) && i != j)
                    ball++;
            }
        }
        return ball;
    }
}

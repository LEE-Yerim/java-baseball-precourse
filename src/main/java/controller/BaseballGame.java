package controller;

import view.InputView;

public class BaseballGame {
    InputView inputView = new InputView();

    public void start(){
        String numbers = inputView.inputNumbers();
    }
}

package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String inputNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.next();
    }
}

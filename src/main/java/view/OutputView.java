package view;

public class OutputView {
    public void outputStrikeBall(int strike, int ball) {
        if(strike==3) {
            System.out.println("3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}

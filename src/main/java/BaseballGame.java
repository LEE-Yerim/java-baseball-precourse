import java.util.Scanner;

public class BaseballGame {
    static Scanner sc = new Scanner(System.in);

    static int newGame;
    static boolean newInput;

    static int strike;
    static int ball;

    public static void functionResult(int strike, int ball) {
        if (strike==0 && ball==0) System.out.println(ball+"볼 "+strike+"스트라이크");
        else if (strike == 0) System.out.println(ball+"볼");
        else if (ball == 0) System.out.println(strike+"스트라이크");
        else System.out.println(ball+"볼 "+strike+"스트라이크");
        if (strike == 3) {
            newInput = false;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            newGame = sc.nextInt();
        }
    }

    public static void functionCount1(int rnum[], int num[]) {
        for(int i=0;i<num.length;i++) {
            for(int j=0;j<num.length;j++) {
                functionCount2(rnum, num, i, j);
            }
        }
    }

    public static void functionCount2(int rnum[], int num[], int i, int j) {
        if(rnum[i] == num[j]) {
            if(i==j) strike++;
            else ball++;
        }
    }
    public static void main(String[] args) {

        newGame = 1;

        int rnum[] = new int[3];
        int num[] = new int[3];

        while(newGame == 1) {
            for (int i=0;i<rnum.length;i++) {
                rnum[i] = (int)(Math.random()*9+1);
                for(int j=0;j<i;j++) {
                    if(rnum[i]==rnum[j]) {
                        i--;
                    }
                }
            }

            newInput = true;

            while(newInput) {
                strike = 0;
                ball = 0;

                System.out.print("숫자를 입력해 주세요 : ");
                String word = sc.next();

                for(int i=0;i<num.length;i++) {
                    num[i] = Character.getNumericValue(word.charAt(i));
                }

                functionCount1(rnum, num);

                functionResult(strike, ball);
            }
        }
    }
}

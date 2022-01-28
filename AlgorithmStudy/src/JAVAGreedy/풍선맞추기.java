package JAVAGreedy;

import java.util.Scanner;

public class 풍선맞추기 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int balloonNum = Integer.parseInt(scan.nextLine());

        String[] firstLine = (scan.nextLine()).split(" ");
        int[] subBalloon = new int[balloonNum];
        for (int i = 0; i < balloonNum; i++) {
            subBalloon[i] = Integer.parseInt(firstLine[i]);
        }
        int[] balloonList = new int[1000001];

        int result = 0;
        for (int i : subBalloon) {
            if (balloonList[i] == 0) {
                balloonList[i - 1]++;
                result++;

            } else {
                balloonList[i]--;
                balloonList[i - 1]++;
            }
        }

        System.out.println(result);

    }

}
package JAVADepthFirstSearch;

import java.util.Scanner;

public class 내리막길 {

    static int height, width;
    static int[] upDown = { -1, 1, 0, 0 };
    static int[] leftRight = { 0, 0, -1, 1 };
    static int[][] board, dp;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);

        board = new int[height][width];
        dp = new int[height][width];

        for (int i = 0; i < height; i++) {
            String[] secondLine = (scan.nextLine()).split(" ");

            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(secondLine[j]);
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(new int[] { 0, 0 }));

    }

    private static int dfs(int[] thisLocation) {

        if (dp[thisLocation[0]][thisLocation[1]] != -1) {
            return dp[thisLocation[0]][thisLocation[1]];
        }

        if (thisLocation[0] == (height - 1) && thisLocation[1] == (width - 1)) {
            return 1;
        }

        dp[thisLocation[0]][thisLocation[1]] = 0;
        for (int i = 0; i < 4; i++) {
            int thisHeight = (thisLocation[0] + upDown[i]);
            int thisWidth = (thisLocation[1] + leftRight[i]);

            if (thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width) {
                if (board[thisHeight][thisWidth] < board[thisLocation[0]][thisLocation[1]]) {
                    dp[thisLocation[0]][thisLocation[1]] += dfs(new int[] { thisHeight, thisWidth });
                }
            }
        }

        return dp[thisLocation[0]][thisLocation[1]];
    }

}

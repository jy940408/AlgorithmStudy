package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 전쟁_전투 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int height, width, wResult = 0, bResult = 0;
    static String[][] board;
    static int[] upDown = { -1, 1, 0, 0 };
    static int[] leftRight = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        width = Integer.parseInt(firstLine[0]);
        height = Integer.parseInt(firstLine[1]);
        board = new String[height][width];
        boolean[][] visitList = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String[] secondLine = (br.readLine()).split("");
            for (int j = 0; j < width; j++) {
                board[i][j] = secondLine[j];
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visitList[i][j]) {
                    bfs(i, j, visitList);
                }
            }
        }

        br.close();
        bw.write(wResult + " " + bResult);
        bw.flush();
        bw.close();

    }

    private static void bfs(int heightRoot, int widthRoot, boolean[][] visitList) {
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { heightRoot, widthRoot, 1 });
        visitList[heightRoot][widthRoot] = true;

        int numCheck = 0;
        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            if (board[thisHeight][thisWidth].equals(board[heightRoot][widthRoot])) {
                numCheck++;
            }

            for (int i = 0; i < 4; i++) {
                int subHeight = (thisHeight + upDown[i]);
                int subWidth = (thisWidth + leftRight[i]);

                if (subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width) {
                    if (board[subHeight][subWidth].equals(board[heightRoot][widthRoot])) {
                        if (!visitList[subHeight][subWidth]) {
                            visitList[subHeight][subWidth] = true;
                            bfsQueue.add(new int[] { subHeight, subWidth, (thisQueue[2] + 1) });
                        }
                    }
                }
            }
        }

        if (board[heightRoot][widthRoot].equals("W")) {
            wResult += (numCheck * numCheck);
        } else {
            bResult += (numCheck * numCheck);
        }

    }

}

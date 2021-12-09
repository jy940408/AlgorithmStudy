package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 쉬운최단거리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] upDown = { -1, 1, 0, 0 };
        int[] leftRignt = { 0, 0, -1, 1 };

        String[] firstLine = (br.readLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);

        int[][] board = new int[height][width];
        int[][] resultBoard = new int[height][width];
        boolean[][] visitList = new boolean[height][width];

        int startHeight = 0;
        int startWidth = 0;
        for (int i = 0; i < height; i++) {
            String[] secondLine = (br.readLine()).split(" ");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(secondLine[j]);
                if (board[i][j] == 2) {
                    startHeight = i;
                    startWidth = j;
                }
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { startHeight, startWidth, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            for (int i = 0; i < 4; i++) {
                int subHeight = (thisHeight + upDown[i]);
                int subWidth = (thisWidth + leftRignt[i]);

                if (subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width) {
                    if (board[subHeight][subWidth] != 0 && board[subHeight][subWidth] != 2
                            && !visitList[subHeight][subWidth]) {
                        visitList[subHeight][subWidth] = true;
                        resultBoard[subHeight][subWidth] = (thisQueue[2] + 1);
                        bfsQueue.add(new int[] { subHeight, subWidth, (thisQueue[2] + 1) });
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1 && resultBoard[i][j] == 0) {
                    bw.write("-1 ");
                } else {
                    bw.write(resultBoard[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}

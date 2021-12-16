package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 아기상어2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result = 0, height, width;
    static int[][] board, visitList;
    static int[] upDown = { -1, -1, -1, 0, 0, 1, 1, 1 }, leftRight = { -1, 0, 1, -1, 1, -1, -0, 1 };

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);

        board = new int[height][width];
        visitList = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visitList[i][j] = -1;
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            String[] secondLine = (br.readLine()).split(" ");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(secondLine[j]);
                if (board[i][j] == 1) {
                    bfsQueue.add(new int[] { i, j, 0 });
                }
            }
        }

        bfs(bfsQueue);

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

    private static void bfs(Queue<int[]> bfsQueue) {
        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();

            for (int i = 0; i < 8; i++) {
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if (subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width) {
                    if (visitList[subHeight][subWidth] == -1) {
                        if (board[subHeight][subWidth] == 0) {
                            visitList[subHeight][subWidth] = (thisQueue[2] + 1);
                            if (result < visitList[subHeight][subWidth]) {
                                result = visitList[subHeight][subWidth];
                            }
                            bfsQueue.add(new int[] { subHeight, subWidth, (thisQueue[2] + 1) });
                        }
                    }
                }
            }
        }
    }

}

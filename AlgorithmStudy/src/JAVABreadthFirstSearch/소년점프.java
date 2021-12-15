package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 소년점프 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = { -1, 1, 0, 0 }, leftRight = { 0, 0, -1, 1 };
    static int height, width;
    static int[][] board;
    static int[][][] visitLength;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);
        board = new int[height][width];
        visitLength = new int[height][width][3];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 3; k++) {
                    visitLength[i][j][k] = -1;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            String[] secondLine = (br.readLine()).split("");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            String[] secondLine = (br.readLine()).split(" ");
            int startHeight = Integer.parseInt(secondLine[0]);
            int startWidth = Integer.parseInt(secondLine[1]);
            visitLength[(startHeight - 1)][(startWidth - 1)][i] = 0;
            bfs(i, (startHeight - 1), (startWidth - 1));
        }

        int resultTime = 1000000000;
        int resultNum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int goalTime = Math.max(Math.max(visitLength[i][j][0], visitLength[i][j][1]), visitLength[i][j][2]);
                if (Math.min(Math.min(visitLength[i][j][0], visitLength[i][j][1]), visitLength[i][j][2]) != -1) {
                    if (resultTime > goalTime) {
                        resultTime = goalTime;
                        resultNum = 1;
                    } else if (resultTime == goalTime) {
                        resultNum += 1;
                    }
                }
            }
        }

        if (resultNum != 0) {
            bw.write(resultTime + "\n" + resultNum);
        } else {
            bw.write(-1 + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int personIdx, int heightRoot, int widthRoot) {
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { heightRoot, widthRoot, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();

            for (int i = 0; i < 4; i++) {
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if (subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width) {
                    if (board[subHeight][subWidth] == 0) {
                        if (visitLength[subHeight][subWidth][personIdx] == -1) {
                            visitLength[subHeight][subWidth][personIdx] = (thisQueue[2] + 1);
                            bfsQueue.add(new int[] { subHeight, subWidth, (thisQueue[2] + 1) });
                        }
                    }
                }
            }
        }

    }
}

package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = { -1, 1, 0, 0, 0, 0 }, leftRight = { 0, 0, -1, 1, 0, 0 }, depthList = { 0, 0, 0, 0, -1, 1 };
    static int result, width, height, depth;
    static int[][][] board;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        depth = Integer.parseInt(firstLine[2]);
        width = Integer.parseInt(firstLine[0]);
        height = Integer.parseInt(firstLine[1]);
        board = new int[depth][height][width];
        boolean[][][] visitList = new boolean[depth][height][width];

        Queue<int[]> bfsQueue = new LinkedList<>();
        boolean tomatoCheck = false;
        boolean ripeCheck = false;

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < height; j++) {
                String[] secondLine = (br.readLine()).split(" ");
                for (int k = 0; k < width; k++) {
                    board[i][j][k] = Integer.parseInt(secondLine[k]);
                    if (board[i][j][k] == 1) {
                        bfsQueue.add(new int[] { i, j, k, 0 });
                        tomatoCheck = true;
                    } else if (board[i][j][k] == 0) {
                        ripeCheck = true;
                    }
                }
            }
        }

        boolean resultCheck = true;
        if (tomatoCheck && ripeCheck) {
            bfs(bfsQueue, visitList);

            for (int i = 0; i < depth; i++) {
                for (int j = 0; j < height; j++) {
                    for (int k = 0; k < width; k++) {
                        if (board[i][j][k] == 0) {
                            resultCheck = false;
                            break;
                        }
                    }
                }
            }

            if (resultCheck && result != 0) {
                bw.write(result + "");
            } else if (resultCheck && result == 0) {
                bw.write(0 + "");
            } else if (!resultCheck) {
                bw.write(-1 + "");
            }
        } else if (!tomatoCheck && ripeCheck) {
            bw.write(-1 + "");
        } else if (tomatoCheck && !ripeCheck) {
            bw.write(0 + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(Queue<int[]> bfsQueue, boolean[][][] visitList) {
        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();

            if (result < thisQueue[3]) {
                result = thisQueue[3];
            }

            for (int i = 0; i < 6; i++) {
                int subDepth = (thisQueue[0] + depthList[i]);
                int subHeight = (thisQueue[1] + upDown[i]);
                int subWidth = (thisQueue[2] + leftRight[i]);

                if (subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width && subDepth >= 0
                        && subDepth < depth) {
                    if (board[subDepth][subHeight][subWidth] == 0) {
                        if (!visitList[subDepth][subHeight][subWidth]) {
                            board[subDepth][subHeight][subWidth] = 1;
                            visitList[subDepth][subHeight][subWidth] = true;
                            bfsQueue.add(new int[] { subDepth, subHeight, subWidth, (thisQueue[3] + 1) });
                        }
                    }
                }
            }
        }

    }

}

package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 윌리암슨수액빨이딱따구리가정보섬에올라온이유 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = { -1, 1, 0, 0 }, leftRight = { 0, 0, -1, 1 };
    static int[][] board;
    static int height, width, result;
    static boolean resultCheck = false;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);
        board = new int[height][width];
        boolean[][] visitList = new boolean[height][width];

        int startHeight = 0, startWidth = 0;
        for (int i = 0; i < height; i++) {
            String[] secondLine = (br.readLine()).split("");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(secondLine[j]);
                if (board[i][j] == 2) {
                    startHeight = i;
                    startWidth = j;
                }
            }
        }

        bfs(startHeight, startWidth, visitList);

        if (resultCheck) {
            bw.write("TAK\n" + result);
        } else {
            bw.write("NIE");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int startHeight, int startWidth, boolean[][] visitList) {
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { startHeight, startWidth, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            for (int i = 0; i < 4; i++) {
                int subHeight = (thisHeight + upDown[i]);
                int subWidth = (thisWidth + leftRight[i]);

                if (subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width) {
                    if (!visitList[subHeight][subWidth] && board[subHeight][subWidth] != 1) {
                        if (board[subHeight][subWidth] == 3 || board[subHeight][subWidth] == 4
                                || board[subHeight][subWidth] == 5) {
                            result = (thisQueue[2] + 1);
                            resultCheck = true;
                            return;
                        }
                        visitList[subHeight][subWidth] = true;
                        bfsQueue.add(new int[] { subHeight, subWidth, (thisQueue[2] + 1) });
                    }
                }
            }
        }

    }

}

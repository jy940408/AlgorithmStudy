package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 무한부스터 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result, height, width;
    static int[][] board;
    static int[] down = { 1, 0 }, right = { 0, 1 };

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);

        board = new int[height][width];
        boolean[][] visitList = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String[] secondLine = (br.readLine()).split(" ");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        bfs(visitList);

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

    private static void bfs(boolean[][] visitList) {

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { 0, 0, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < (board[thisHeight][thisWidth] + 1); j++) {
                    int subHeight = (thisHeight + down[i] * j);
                    int subWidth = (thisWidth + right[i] * j);

                    if (subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width) {
                        if (!visitList[subHeight][subWidth]) {
                            if (subHeight == (height - 1) && subWidth == (width - 1)) {
                                result = (thisQueue[2] + 1);
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

}

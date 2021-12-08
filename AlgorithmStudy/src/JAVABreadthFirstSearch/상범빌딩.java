package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 상범빌딩 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int floor, height, width, result;
    static int[] upDown = { -1, 1, 0, 0, 0, 0 }, leftRight = { 0, 0, -1, 1, 0, 0 }, topBottom = { 0, 0, 0, 0, -1, 1 };
    static boolean resultCheck = false;

    public static void main(String[] args) throws IOException {

        String firstLine = "";
        while (!firstLine.equals("0 0 0")) {
            result = 0;
            resultCheck = false;

            firstLine = br.readLine();
            String[] firstLine_ = firstLine.split(" ");
            floor = Integer.parseInt(firstLine_[0]);
            height = Integer.parseInt(firstLine_[1]);
            width = Integer.parseInt(firstLine_[2]);

            String[][][] board = new String[floor][height][width];
            boolean[][][] visitList = new boolean[floor][height][width];

            int startFloor = 0;
            int startHeight = 0;
            int startWidth = 0;

            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < height; j++) {
                    String[] secondLine = (br.readLine()).split("");
                    for (int k = 0; k < width; k++) {
                        board[i][j][k] = secondLine[k];
                        if (board[i][j][k].equals("S")) {
                            startFloor = i;
                            startHeight = j;
                            startWidth = k;
                        }
                    }
                }
                br.readLine();
            }

            bfs(startFloor, startHeight, startWidth, board, visitList);

            if (!firstLine.equals("0 0 0")) {
                if (resultCheck) {
                    bw.write("Escaped in " + result + " minute(s).\n");
                } else {
                    bw.write("Trapped!\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int floorRoot, int heightRoot, int widthRoot, String[][][] board, boolean[][][] visitList) {

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { floorRoot, heightRoot, widthRoot, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            int thisFloor = thisQueue[0];
            int thisHeight = thisQueue[1];
            int thisWidth = thisQueue[2];

            for (int i = 0; i < 6; i++) {
                int subFloor = (thisFloor + topBottom[i]);
                int subHeight = (thisHeight + upDown[i]);
                int subWidth = (thisWidth + leftRight[i]);

                if (subFloor >= 0 && subFloor < floor && subHeight >= 0 && subHeight < height && subWidth >= 0
                        && subWidth < width) {
                    if (!visitList[subFloor][subHeight][subWidth]
                            && !board[subFloor][subHeight][subWidth].equals("#")) {
                        if (board[subFloor][subHeight][subWidth].equals("E")) {
                            result = (thisQueue[3] + 1);
                            resultCheck = true;
                            return;
                        }
                        visitList[subFloor][subHeight][subWidth] = true;
                        bfsQueue.add(new int[] { subFloor, subHeight, subWidth, (thisQueue[3] + 1) });
                    }

                }
            }

        }

    }

}

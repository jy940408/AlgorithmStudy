package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 완전범죄 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int buildingNum, startNum, goalNum, forwardNum, backNum, policeNum, result;
    static boolean resultCheck = false;
    static int[] board, moveList;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        buildingNum = Integer.parseInt(firstLine[0]);
        startNum = Integer.parseInt(firstLine[1]);
        goalNum = Integer.parseInt(firstLine[2]);
        forwardNum = Integer.parseInt(firstLine[3]);
        backNum = Integer.parseInt(firstLine[4]);
        policeNum = Integer.parseInt(firstLine[5]);

        moveList = new int[] { forwardNum, backNum };
        board = new int[(buildingNum + 1)];
        boolean[] visitList = new boolean[(buildingNum + 1)];

        if (policeNum != 0) {
            String[] policeList = (br.readLine()).split(" ");
            for (int i = 0; i < policeNum; i++) {
                board[Integer.parseInt(policeList[i])] = 1;
            }
        }

        bfs(startNum, visitList);

        if (resultCheck) {
            bw.write(result + "");
        } else {
            bw.write("BUG FOUND");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int root, boolean[] visitList) {

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { root, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            int thisRoot = thisQueue[0];

            if (thisRoot == goalNum) {
                result = thisQueue[1];
                resultCheck = true;
            }

            for (int i = 0; i < 2; i++) {
                int subRoot = 0;
                if (i == 0) {
                    subRoot = (thisRoot + moveList[i]);
                } else {
                    subRoot = (thisRoot - moveList[i]);
                }

                if (subRoot >= 1 && subRoot < (buildingNum + 1)) {
                    if (!visitList[subRoot]) {
                        if (board[subRoot] != 1) {
                            visitList[subRoot] = true;
                            bfsQueue.add(new int[] { subRoot, (thisQueue[1] + 1) });
                        }
                    }
                }
            }

        }

    }

}

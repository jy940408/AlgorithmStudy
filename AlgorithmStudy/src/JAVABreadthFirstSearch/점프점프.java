package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 점프점프 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] board;
    static int allNum, result;
    static boolean[] visitList;
    static boolean trueCheck = false;

    public static void main(String[] args) throws IOException {

        allNum = Integer.parseInt(br.readLine());
        board = new int[allNum];
        visitList = new boolean[allNum];
        String[] firstLine = (br.readLine()).split(" ");
        for (int i = 0; i < allNum; i++) {
            board[i] = Integer.parseInt(firstLine[i]);
        }

        bfs(0);

        if (trueCheck) {
            bw.write(result + "");
        } else {
            bw.write(-1 + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int root) {

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { root, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();

            if (thisQueue[0] == (allNum - 1)) {
                result = thisQueue[1];
                trueCheck = true;
                return;
            }

            for (int i = 1; i < board[thisQueue[0]] + 1; i++) {
                int subQueue = (thisQueue[0] + i);
                if (subQueue < allNum) {
                    if (!visitList[subQueue]) {
                        visitList[subQueue] = true;
                        bfsQueue.add(new int[] { subQueue, thisQueue[1] + 1 });
                    }
                }
            }

        }

    }

}

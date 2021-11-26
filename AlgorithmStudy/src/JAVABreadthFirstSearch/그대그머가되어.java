package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 그대그머가되어 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean resultCheck = false;
    static int startNum, goalNum, allNum, connectNum, result;
    static ArrayList[] board;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        startNum = Integer.parseInt(firstLine[0]);
        goalNum = Integer.parseInt(firstLine[1]);

        String[] secondLine = (br.readLine()).split(" ");
        allNum = Integer.parseInt(secondLine[0]);
        connectNum = Integer.parseInt(secondLine[1]);

        boolean[] visitList = new boolean[allNum + 1];
        board = new ArrayList[allNum + 1];
        for (int i = 0; i < allNum + 1; i++) {
            board[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < connectNum; i++) {
            String[] thirdLine = (br.readLine()).split(" ");
            int firstNum = Integer.parseInt(thirdLine[0]);
            int secondNum = Integer.parseInt(thirdLine[1]);
            board[firstNum].add(secondNum);
            board[secondNum].add(firstNum);
        }

        bfs(startNum, visitList);

        if (resultCheck) {
            bw.write(result + "");
        } else {
            bw.write(-1 + "");
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
                return;
            }

            for (int i = 0; i < (board[thisRoot]).size(); i++) {
                int subRoot = (int) board[thisRoot].get(i);

                if (subRoot >= 0 && subRoot < allNum + 1) {
                    if (!visitList[subRoot]) {
                        visitList[subRoot] = true;
                        bfsQueue.add(new int[] { subRoot, (thisQueue[1] + 1) });
                    }
                }
            }

        }

    }

}
package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 텔레포트정거장 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int length, startNum, goalNum, result;
    static ArrayList[] board;
    static boolean[] visitList;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        length = Integer.parseInt(firstLine[0]);
        int connectNum = Integer.parseInt(firstLine[1]);

        String[] secondLine = (br.readLine()).split(" ");
        startNum = Integer.parseInt(secondLine[0]);
        goalNum = Integer.parseInt(secondLine[1]);

        board = new ArrayList[length + 1];
        visitList = new boolean[length + 1];
        for (int i = 0; i < length + 1; i++) {
            board[i] = new ArrayList<Integer>();
            board[i].add((i - 1));
            board[i].add((i + 1));
        }

        for (int i = 0; i < connectNum; i++) {
            String[] thirdLine = (br.readLine()).split(" ");
            board[Integer.parseInt(thirdLine[0])].add(Integer.parseInt(thirdLine[1]));
            board[Integer.parseInt(thirdLine[1])].add(Integer.parseInt(thirdLine[0]));
        }

        for (int i = 0; i < length + 1; i++) {
            System.out.println("board: " + board[i]);
        }

        bfs(startNum);

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(int root) {

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { root, 0 });

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            int thisRoot = thisQueue[0];
            System.out.println("thisRoot: " + thisRoot + ", thisLength: " + thisQueue[1]);

            if (thisRoot == goalNum) {
                result = thisQueue[1];
                return;
            }

            for (int i = 0; i < (board[thisRoot]).size(); i++) {
                int subRoot = (int) board[thisRoot].get(i);

                if (subRoot >= 1 && subRoot < (length + 1)) {
                    if (!visitList[subRoot]) {
                        visitList[subRoot] = true;
                        bfsQueue.add(new int[] { subRoot, ((int) thisQueue[1] + 1) });
                    }
                }
            }
        }

    }

}

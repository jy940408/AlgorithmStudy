package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 돌다리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int firstNum, secondNum, startNum, goalNum, result;
    static int[] turn;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        firstNum = Integer.parseInt(firstLine[0]);
        secondNum = Integer.parseInt(firstLine[1]);
        startNum = Integer.parseInt(firstLine[2]);
        goalNum = Integer.parseInt(firstLine[3]);

        boolean[] visitList = new boolean[100001];
        turn = new int[] { -1, 1, -firstNum, -secondNum, firstNum, secondNum };

        bfs(startNum, visitList);

        br.close();
        bw.write(result + "");
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
                return;
            }

            for (int i = 0; i < 6; i++) {
                int subRoot = (thisRoot + turn[i]);

                if (subRoot >= 0 && subRoot < 100001) {
                    if (!visitList[subRoot]) {
                        visitList[subRoot] = true;
                        bfsQueue.add(new int[] { subRoot, (thisQueue[1] + 1) });
                    }
                }

                if (i == 4 || i == 5) {
                    int multiRoot = (thisRoot * turn[i]);

                    if (multiRoot >= 0 && multiRoot < 100001) {
                        if (!visitList[multiRoot]) {
                            visitList[multiRoot] = true;
                            bfsQueue.add(new int[] { multiRoot, (thisQueue[1] + 1) });
                        }
                    }
                }
            }

        }

    }

}

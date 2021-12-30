package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 태권왕 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int roundNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < roundNum; i++) {
            String[] firstLine = (br.readLine()).split(" ");
            int startNum = Integer.parseInt(firstLine[0]);
            int goalNum = Integer.parseInt(firstLine[1]);

            bw.write(bfs(startNum, goalNum) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int bfs(int firstNum, int secondNum) {

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] { firstNum, secondNum, 0 });

        int[] check = new int[200];
        for (int i = 0; i < 200; i++) {
            check[i] = -1;
        }

        while (!bfsQueue.isEmpty()) {
            int[] thisQueue = bfsQueue.poll();
            if (thisQueue[1] >= thisQueue[0] && check[thisQueue[0]] == -1) {
                bfsQueue.add(new int[] { thisQueue[0] * 2, thisQueue[1] + 3, thisQueue[2] + 1 });
                bfsQueue.add(new int[] { thisQueue[0] + 1, thisQueue[1], thisQueue[2] + 1 });

                if (thisQueue[0] == thisQueue[1]) {
                    return thisQueue[2];
                }
            }
        }

        return 0;
    }

}
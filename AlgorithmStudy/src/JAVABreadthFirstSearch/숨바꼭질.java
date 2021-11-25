package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int startNum, goalNum, result;

    public static void main(String[] args) throws IOException {

        boolean[] visitList = new boolean[100001];
        String[] firstLine = (br.readLine()).split(" ");
        startNum = Integer.parseInt(firstLine[0]);
        goalNum = Integer.parseInt(firstLine[1]);

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

            int subRoot = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    subRoot = (thisRoot - 1);
                } else if (i == 1) {
                    subRoot = (thisRoot + 1);
                } else {
                    subRoot = thisRoot * 2;
                }

                if (subRoot >= 0 && subRoot <= 100000) {
                    if (!visitList[subRoot]) {
                        visitList[subRoot] = true;
                        bfsQueue.add(new int[] { subRoot, (thisQueue[1] + 1) });
                    }

                }
            }
        }

    }

}

package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class AtoB {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long startNum, goalNum, result;
    static boolean resultCheck;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        startNum = Long.parseLong(firstLine[0]);
        goalNum = Long.parseLong(firstLine[1]);

        bfs();

        if (resultCheck) {
            bw.write(result + "");
        } else {
            bw.write(-1 + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs() {

        Queue<long[]> bfsDeque = new LinkedList<>();
        bfsDeque.add(new long[] { startNum, 0 });

        while (!bfsDeque.isEmpty()) {
            long[] thisDeque = bfsDeque.poll();

            for (int i = 0; i < 2; i++) {
                long subNum = 0;
                if (i == 0) {
                    subNum = (thisDeque[0] * 2);
                } else {
                    subNum = (thisDeque[0] * 10) + 1;
                }

                if (subNum <= goalNum) {
                    if (subNum == goalNum) {
                        result = (thisDeque[1] + 2);
                        resultCheck = true;
                        return;
                    }
                    bfsDeque.add(new long[] { subNum, (thisDeque[1] + 1) });
                }

            }
        }

    }
}

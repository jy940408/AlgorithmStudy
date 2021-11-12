package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 트리와쿼리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] nodeNum;

    public static void main(String[] args) throws IOException {

        String[] firstLine = (br.readLine()).split(" ");
        int node = Integer.parseInt(firstLine[0]);
        int root = Integer.parseInt(firstLine[1]);
        int query = Integer.parseInt(firstLine[2]);

        ArrayList[] edge = new ArrayList[node + 1];
        for (int i = 0; i < edge.length; i++) {
            edge[i] = new ArrayList<Integer>();
        }

        nodeNum = new int[node + 1];

        for (int i = 0; i < node - 1; i++) {
            String[] secondLine = (br.readLine()).split(" ");
            int first = Integer.parseInt(secondLine[0]);
            int second = Integer.parseInt(secondLine[1]);
            edge[first].add(second);
            edge[second].add(first);
        }

        boolean[] visitList = new boolean[node + 1];
        treeCheck(root, edge, visitList);

        for (int i = 0; i < query; i++) {
            int rootNum = Integer.parseInt(br.readLine());
            bw.write(nodeNum[rootNum] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int treeCheck(int root, ArrayList[] edge, boolean[] visitList) {

        visitList[root] = true;
        int thisNode = 1;

        for (Object i : edge[root]) {
            if (!visitList[(int) i]) {
                thisNode += treeCheck((int) i, edge, visitList);
            }
        }

        nodeNum[root] += thisNode;

        return nodeNum[root];

    }
}

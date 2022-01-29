package JAVADepthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 떡장수와호랑이 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int dayNum;
    static ArrayList<int[]> riceList = new ArrayList<int[]>();
    static boolean[][] visitList;

    public static void main(String[] args) throws IOException {

        dayNum = Integer.parseInt(br.readLine());

        visitList = new boolean[dayNum][10];
        for (int i = 0; i < dayNum; i++) {
            String[] firstLine = (br.readLine()).split(" ");

            int riceNum = Integer.parseInt(firstLine[0]);
            int[] subList = new int[riceNum];
            for (int j = 1; j < (riceNum + 1); j++) {
                subList[j - 1] = Integer.parseInt(firstLine[j]);
            }

            riceList.add(subList);
        }

        dfs(0, 0, new int[dayNum]);

        bw.write("-1");
        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int today, int yesterday, int[] list) throws IOException {

        if (today == dayNum) {
            for (int i = 0; i < dayNum; i++) {
                bw.write(list[i] + "\n");
            }

            br.close();
            bw.flush();
            bw.close();

            System.exit(0);
        }

        for (int i : riceList.get(today)) {
            if (!visitList[today][i]) {
                if (i != yesterday) {
                    visitList[today][i] = true;
                    list[today] = i;
                    dfs((today + 1), i, list);
                }
            }
        }
    }

}
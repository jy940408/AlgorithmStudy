package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 현명한나이트 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] leftRight = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int length, goalNum, startHeight, startWidth;
    static int[][] board;

    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        length = Integer.parseInt(firstLine[0]);
        goalNum = Integer.parseInt(firstLine[1]);

        String[] secondLine = (br.readLine()).split(" ");
        startHeight = Integer.parseInt(secondLine[0]);
        startWidth = Integer.parseInt(secondLine[1]);

        board = new int[length+1][length+1];
        boolean[][] visitList = new boolean[length+1][length+1];

        bfs(new int[] {startHeight, startWidth}, visitList);

        String result = "";
        for(int i = 0 ; i < goalNum ; i++){
            String[] thirdLine = (br.readLine()).split(" ");
            result += (board[Integer.parseInt(thirdLine[0])][Integer.parseInt(thirdLine[1])] + " ");
        }

        br.close();
        bw.write(result);
        bw.flush();
        bw.close();

    }

    private static void bfs(int[] startRoot, boolean[][] visitList){
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {startRoot[0], startRoot[1], 0});

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            board[thisHeight][thisWidth] = thisQueue[2];

            for(int i = 0 ; i < 8 ; i++){
                int subHeight = (thisHeight + upDown[i]);
                int subWidth = (thisWidth + leftRight[i]);

                if(subHeight >= 1 && subHeight < (length+1) && subWidth >= 1 && subWidth < (length+1)){
                    if(!visitList[subHeight][subWidth]){
                        visitList[subHeight][subWidth] = true;
                        bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1)});
                    }
                }
            }
        }
    }
}

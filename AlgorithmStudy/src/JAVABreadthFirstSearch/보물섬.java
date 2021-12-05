package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 보물섬 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};
    static int result, height, width;
    static String[][] board;

    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);
        board = new String[height][width];

        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];
            }
        }

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j].equals("L")){
                    boolean[][] visitList = new boolean[height][width];
                    bfs(i, j, visitList);
                }
            }
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

    private static void bfs(int heightRoot, int widthRoot, boolean[][] visitList){

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {heightRoot, widthRoot, 0});
        visitList[heightRoot][widthRoot] = true;

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            result = Math.max(result, thisQueue[2]);

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisHeight + upDown[i]);
                int subWidth = (thisWidth + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(!visitList[subHeight][subWidth] && board[subHeight][subWidth].equals("L")){
                        visitList[subHeight][subWidth] = true;
                        bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1)});
                    }
                }
            }
        }

    }

}

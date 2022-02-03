package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 말이되고픈원숭이 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};
    static int[] knightHeight = {-1, -2, -2, -1, 1, 2, 2, 1}, knightWidth = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException{
        
        int knightNum = Integer.parseInt(br.readLine());
        
        String[] firstLine = (br.readLine()).split(" ");
        int width = Integer.parseInt(firstLine[0]), height = Integer.parseInt(firstLine[1]);

        int[][] board = new int[height][width];
        boolean[][][] visitList = new boolean[knightNum+1][height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, 0, 0});

        int result = -1;
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == (height-1) && thisQueue[1] == (width-1)){
                result = thisQueue[3];
                break;
            }

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(!visitList[thisQueue[2]][subHeight][subWidth]){
                        if(board[subHeight][subWidth] != 1){
                            visitList[thisQueue[2]][subHeight][subWidth] = true;
                            bfsQueue.add(new int[] {subHeight, subWidth, thisQueue[2], (thisQueue[3]+1)});
                        }
                    }
                }
            }

            if(thisQueue[2] < knightNum){
                for(int i = 0 ; i < 8 ; i ++){
                    int subHeight = (thisQueue[0] + knightHeight[i]);
                    int subWidth = (thisQueue[1] + knightWidth[i]);

                    if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                        if(!visitList[thisQueue[2]+1][subHeight][subWidth]){
                            if(board[subHeight][subWidth] != 1){
                                visitList[thisQueue[2]+1][subHeight][subWidth] = true;
                                bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1), (thisQueue[3]+1)});
                            }
                        }
                    }
                }
            }
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

}

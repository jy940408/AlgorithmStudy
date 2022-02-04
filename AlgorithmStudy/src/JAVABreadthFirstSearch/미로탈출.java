package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        firstLine = (br.readLine()).split(" ");
        int nowHeight = Integer.parseInt(firstLine[0]), nowWidth = Integer.parseInt(firstLine[1]);

        firstLine = (br.readLine()).split(" ");
        int escapeHeight = Integer.parseInt(firstLine[0]), escapeWidth = Integer.parseInt(firstLine[1]);

        int[][] board = new int[height][width];
        boolean[][][] visitList = new boolean[2][height][width];
        for(int i = 0 ; i < height ; i++){
            firstLine = (br.readLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(firstLine[j]);
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {(nowHeight-1), (nowWidth-1), 0, 0});
        
        int result = -1;
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == (escapeHeight-1) && thisQueue[1] == (escapeWidth-1)){
                result = thisQueue[3];
                break;
            }

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(!visitList[thisQueue[2]][subHeight][subWidth]){
                        if(board[subHeight][subWidth] == 0){
                            visitList[thisQueue[2]][subHeight][subWidth] = true;
                            bfsQueue.add(new int[] {subHeight, subWidth, thisQueue[2], (thisQueue[3]+1)});
                        
                        }else{
                            if(thisQueue[2] == 0){
                                visitList[thisQueue[2]][subHeight][subWidth] = true;
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

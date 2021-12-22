package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 경쟁적전염 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        
        String[] firstLine = (br.readLine()).split(" ");
        int length = Integer.parseInt(firstLine[0]);
        int virusNum = Integer.parseInt(firstLine[1]);
        int[][][] board = new int[length][length][2];
        ArrayList[] virusList = new ArrayList[virusNum+1];

        for(int i = 0 ; i < (virusNum+1) ; i++){
            virusList[i] = new ArrayList<int[]>();
        }

        for(int i = 0 ; i < length ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            for(int j = 0 ; j < length ; j++){
                board[i][j][0] = Integer.parseInt(secondLine[j]);
                if(board[i][j][0] != 0){
                    virusList[board[i][j][0]].add(new int[] {i, j});
                }   
            }
        }

        String[] secondLine = (br.readLine()).split(" ");
        int goalTime = Integer.parseInt(secondLine[0]);
        int goalHeight = Integer.parseInt(secondLine[1]);
        int goalWidth = Integer.parseInt(secondLine[2]);

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 1 ; i < (virusNum+1) ; i++){
            if(virusList[i].size() != 0){
                for(int j = 0 ; j < virusList[i].size() ; j++){
                    bfsQueue.add(new int[] {((int[])virusList[i].get(j))[0], ((int[])virusList[i].get(j))[1], i , 0});
                }
            }
        }

        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < length && subWidth >= 0 && subWidth < length){
                    if(board[subHeight][subWidth][0] == 0){
                        board[subHeight][subWidth][0] = thisQueue[2];
                        board[subHeight][subWidth][1] = (thisQueue[3]+1);

                        bfsQueue.add(new int[] {subHeight, subWidth, thisQueue[2], (thisQueue[3]+1)});
                    }
                }
            }
        }

        if(board[goalHeight-1][goalWidth-1][1] <= goalTime){
            bw.write(board[goalHeight-1][goalWidth-1][0] + "");
        }else {
            bw.write(0 + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}

package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 점프게임 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        int goalNum = Integer.parseInt(firstLine[0]);
        int jumpNum = Integer.parseInt(firstLine[1]);

        int[] upDown = {1, -1, jumpNum};
        int[] leftRight = {0, 0};

        String[] leftLine = (br.readLine()).split("");
        String[] rightLine = (br.readLine()).split("");

        int[][] board = new int[2][goalNum];
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < goalNum ; j++){
                if(i == 0){
                    board[i][j] = Integer.parseInt(leftLine[j]);
                }else{
                    board[i][j] = Integer.parseInt(rightLine[j]);
                }
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, 0});
        boolean resultCheck = false;

        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 3 ; i++){
                int subHeight, subWidth;
                if(i == 0 || i == 1){
                    subHeight = (thisQueue[0] + leftRight[i]);
                    subWidth = (thisQueue[1] + upDown[i]);
                }else{
                    if(thisQueue[0] == 0){
                        subHeight = 1;
                    }else{
                        subHeight = 0;
                    }
                    subWidth = (thisQueue[1] + upDown[i]);
                }

                if(subWidth >= (thisQueue[2]+1) && subWidth < goalNum){
                    if(board[subHeight][subWidth] == 1){
                        board[subHeight][subWidth] = -1;
                        bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1)});
                    }
                }else if(subWidth >= goalNum){
                    resultCheck = true;
                    break loop;
                }
            }
        }

        if(resultCheck){
            bw.write(1 + "");
        }else{
            bw.write(0 + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}

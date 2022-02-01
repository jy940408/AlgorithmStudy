package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기2 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        int wallNum = Integer.parseInt(firstLine[2]);

        int[][] board = new int[height][width];
        int[][][] visitList = new int[wallNum+1][height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, 0, 1});

        visitList[0][0][0] = -1;
        int result = 0;
        boolean resultCheck = false;
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == (height-1) && thisQueue[1] == (width-1)){
                result = thisQueue[3];
                resultCheck = true;
                break;
            }

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(board[subHeight][subWidth] == 0){
                        if(visitList[thisQueue[2]][subHeight][subWidth] == 0){
                            visitList[thisQueue[2]][subHeight][subWidth] = 1;
                            bfsQueue.add(new int[] {subHeight, subWidth, thisQueue[2], (thisQueue[3]+1)});
                        }
                    
                    }else{
                        if(thisQueue[2] < wallNum){
                            if(visitList[thisQueue[2]+1][subHeight][subWidth] == 0){
                                visitList[thisQueue[2]+1][subHeight][subWidth] = 1;
                                bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1), thisQueue[3]+1});
                            }
                        }
                    }
                }
            }
        }

        if(resultCheck){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }


    }

}

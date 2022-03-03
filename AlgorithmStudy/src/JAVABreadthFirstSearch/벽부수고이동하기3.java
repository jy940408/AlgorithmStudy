package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기3 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        int crashNum = Integer.parseInt(firstLine[2]);

        int[][] board = new int[height][width];
        boolean[][][] visitList = new boolean[crashNum+1][height][width];
        visitList[0][0][0] = true;
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, 1, 0, 1});

        int result = -1;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int thisHeight = (thisQueue[0] + upDown[i]);
                int thisWidth = (thisQueue[1] + leftRight[i]);

                if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                    if(board[thisHeight][thisWidth] == 0){
                        if(!visitList[thisQueue[3]][thisHeight][thisWidth]){
                            visitList[thisQueue[3]][thisHeight][thisWidth] = true;
                            bfsQueue.add(new int[] {thisHeight, thisWidth, (-1*thisQueue[2]), thisQueue[3], (thisQueue[4]+1)});
                            
                            if(thisHeight == (height-1) && thisWidth == (width-1)){
                                result = (thisQueue[4] + 1);
                                break loop;
                            }
                        }
                    }else{
                        if(thisQueue[3] < crashNum){
                            if(!visitList[thisQueue[3]+1][thisHeight][thisWidth]){
                                if(thisQueue[2] == 1){
                                    visitList[thisQueue[3]+1][thisHeight][thisWidth] = true;
                                    bfsQueue.add(new int[] {thisHeight, thisWidth, (-1*thisQueue[2]), (thisQueue[3]+1), (thisQueue[4]+1)});
                                
                                }else{
                                    bfsQueue.add(new int[] {thisQueue[0], thisQueue[1], (-1*thisQueue[2]), thisQueue[3], (thisQueue[4]+1)});
                                }
                            }
                        }
                    }
                }
            }
        }

        if(height == 1 && width == 1 && board[0][0] == 0){
            System.out.println(1);
        }else{
            System.out.println(result);
        }

    }

}

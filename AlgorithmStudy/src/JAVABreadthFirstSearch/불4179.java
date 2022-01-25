package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 불4179 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        Queue<int[]> bfsQueue = new LinkedList<>();
        int[] thisPlace = {0, 0};
        String[][] board = new String[height][width];
        int[][] visitList = new int[height][width];

        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];

                if(board[i][j].equals("J")){
                    thisPlace[0] = i;
                    thisPlace[1] = j;
                }else if(board[i][j].equals("F")){
                    bfsQueue.add(new int[] {i, j, 0, -1});
                }
            }
        }
        bfsQueue.add(new int[] {thisPlace[0], thisPlace[1], 0, 1});

        int result = 0;
        boolean resultCheck = false;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(!board[subHeight][subWidth].equals("#")){
                        if(visitList[subHeight][subWidth] == 0){
                            visitList[subHeight][subWidth] = thisQueue[3];
                            bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1), thisQueue[3]});
                        
                        }else if(visitList[subHeight][subWidth] == 1){
                            if(thisQueue[3] == -1){
                                visitList[subHeight][subWidth] = thisQueue[3];
                                bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1), thisQueue[3]});
                            }
                        }
                    }
                
                }else{
                    if(thisQueue[3] == 1){
                        result = (thisQueue[2] + 1);
                        resultCheck = true;
                        break loop;
                    }
                }
            }
        }

        if(resultCheck){
            System.out.println(result);
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }

}

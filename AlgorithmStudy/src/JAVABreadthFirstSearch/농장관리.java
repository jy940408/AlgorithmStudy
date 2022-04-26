package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 농장관리 {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] leftRight = {-1, 0, 1, -1, 1, -1, 0, 1};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        int[][] board = new int[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }
        boolean[][] visitList = new boolean[height][width];

        int result = 0;
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j] > 0 && !visitList[i][j]){
                    boolean heightCheck = true;

                    Queue<int[]> bfsQueue = new LinkedList<>();
                    bfsQueue.add(new int[] {i, j});

                    while(!bfsQueue.isEmpty()){
                        int[] thisQueue = bfsQueue.poll();

                        for(int k = 0 ; k < 8 ; k++){
                            int thisHeight = (thisQueue[0] + upDown[k]);
                            int thisWidth = (thisQueue[1] + leftRight[k]);

                            if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                                if(board[thisQueue[0]][thisQueue[1]] < board[thisHeight][thisWidth]){
                                    heightCheck = false;
                                
                                }else{
                                    if(!visitList[thisHeight][thisWidth]){
                                        if(board[thisQueue[0]][thisQueue[1]] == board[thisHeight][thisWidth]){
                                            visitList[thisHeight][thisWidth] = true;
                                            bfsQueue.add(new int[] {thisHeight, thisWidth});
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if(heightCheck){
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

}

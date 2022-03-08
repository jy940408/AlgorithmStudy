package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Grid {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        int[][] board = new int[height][width];
        boolean[][] visitList = new boolean[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, 0});

        String result = "IMPOSSIBLE";
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == (height-1) && thisQueue[1] == (width-1)){
                result = Integer.toString(thisQueue[2]);
                break;
            }

            for(int i = 0 ; i < 4 ; i++){
                int thisHeight = (thisQueue[0] + (upDown[i]*board[thisQueue[0]][thisQueue[1]]));
                int thisWidth = (thisQueue[1] + (leftRight[i]*board[thisQueue[0]][thisQueue[1]]));
        
                if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                    if(!visitList[thisHeight][thisWidth]){
                        visitList[thisHeight][thisWidth] = true;
                        bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});
                    }
                }
            }
        }

        System.out.println(result);

    }

}

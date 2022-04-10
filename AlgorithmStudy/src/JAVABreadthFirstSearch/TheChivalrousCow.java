package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheChivalrousCow {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] leftRight = {-2, -1, 1, 2, -2, -1, 1, 2};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int width = Integer.parseInt(firstLine[0]), height = Integer.parseInt(firstLine[1]);

        String[][] board = new String[height][width];
        boolean[][] visitList = new boolean[height][width];

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];

                if(board[i][j].equals("K")){
                    bfsQueue.add(new int[] {i, j, 0});
                }
            }
        }

        int result = 0;
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(board[thisQueue[0]][thisQueue[1]].equals("H")){
                result = thisQueue[2];
                break;
            }

            for(int i = 0 ; i < 8 ; i++){
                int thisHeight = (thisQueue[0] + upDown[i]);
                int thisWidth = (thisQueue[1] + leftRight[i]);

                if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                    if(!visitList[thisHeight][thisWidth]){
                        if(!board[thisHeight][thisWidth].equals("*")){
                            visitList[thisHeight][thisWidth] = true;
                            bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2] + 1)});
                        }
                    }
                }
            }            
        }

        System.out.println(result);

    }

}

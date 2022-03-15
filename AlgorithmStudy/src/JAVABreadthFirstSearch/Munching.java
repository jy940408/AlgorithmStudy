package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Munching {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        String[][] board = new String[height][width];
        boolean[][] visitList = new boolean[height][width];

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];

                if(board[i][j].equals("B")){
                    bfsQueue.add(new int[] {i, j, 0});
                }
            }
        }

        int result = 0;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int thisHeight = (thisQueue[0] + upDown[i]);
                int thisWidth = (thisQueue[1] + leftRight[i]);

                if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                    if(!visitList[thisHeight][thisWidth]){
                        if(!board[thisHeight][thisWidth].equals("*")){
                            visitList[thisHeight][thisWidth] = true;
                            bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});

                            if(board[thisHeight][thisWidth].equals("C")){
                                result = (thisQueue[2]+1);
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

}

package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CowsonSkates {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        String[][] board = new String[height][width];
        String[][] idxBoard = new String[height][width];
        idxBoard[0][0] = "1 1";
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0});
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == (height-1) && thisQueue[1] == (width-1)){
                break;
            }

            for(int i = 0 ; i < 4 ; i++){
                int thisHeight = (thisQueue[0] + upDown[i]);
                int thisWidth = (thisQueue[1] + leftRight[i]);

                if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                    if(board[thisHeight][thisWidth].equals(".")){
                        if(idxBoard[thisHeight][thisWidth] == null){
                            idxBoard[thisHeight][thisWidth] = (thisQueue[0] + " " + thisQueue[1]);
                            bfsQueue.add(new int[] {thisHeight, thisWidth});
                        }
                    }
                }
            }
        }

        String result = ("\n" + height + " " + width);
        int thisHeight = (height-1), thisWidth = (width-1);
        while(true){
            if(thisHeight == 0 && thisWidth == 0){
                break;
            }

            String[] secondLine = idxBoard[thisHeight][thisWidth].split(" ");
            thisHeight = Integer.parseInt(secondLine[0]);
            thisWidth = Integer.parseInt(secondLine[1]);

            result = ("\n" + (thisHeight+1) + " " + (thisWidth+1) + result);
        }

        System.out.println(result);

    }

}

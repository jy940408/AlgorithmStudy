package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShebasAmoebas {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, -1, -1, 0, 0, 1, 1, 1}, leftRight = {-1, 0, 1, -1, 1, -1, 0, 1};

        Scanner scan = new Scanner(System.in);
        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
    
        boolean[][] visitList = new boolean[height][width];
        String[][] board = new String[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];
            }
        }

        int result = 0;
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j].equals("#") && !visitList[i][j]){
                    result++;

                    Queue<int[]> bfsQueue = new LinkedList<>();
                    bfsQueue.add(new int[] {i, j});
                    visitList[i][j] = true;

                    while(!bfsQueue.isEmpty()){
                        int[] thisQueue = bfsQueue.poll();

                        for(int k = 0 ; k < 8 ; k++){
                            int thisHeight = (thisQueue[0] + upDown[k]);
                            int thisWidth = (thisQueue[1] + leftRight[k]);

                            if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                                if(board[thisHeight][thisWidth].equals("#")){
                                    if(!visitList[thisHeight][thisWidth]){
                                        visitList[thisHeight][thisWidth] = true;
                                        bfsQueue.add(new int[] {thisHeight, thisWidth});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

}

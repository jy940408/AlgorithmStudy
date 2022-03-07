package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FeedingTime {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] leftRight = {-1, 0, 1, -1, 1, -1, 0, 1};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int width = Integer.parseInt(firstLine[0]), height = Integer.parseInt(firstLine[1]);

        String[][] board = new String[height][width];
        boolean[][] visitList = new boolean[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];
            }
        }

        int result = 0;
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j].equals(".") && !visitList[i][j]){
                    int subResult = 1;
                    visitList[i][j] = true;
                    
                    Queue<int[]> bfsQueue = new LinkedList<>();
                    bfsQueue.add(new int[] {i, j});
                    while(!bfsQueue.isEmpty()){
                        int[] thisQueue = bfsQueue.poll();

                        for(int k = 0 ; k < 8 ; k++){
                            int thisHeight = (thisQueue[0] + upDown[k]);
                            int thisWidth = (thisQueue[1] + leftRight[k]);

                            if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                                if(!visitList[thisHeight][thisWidth]){
                                    if(board[thisHeight][thisWidth].equals(".")){
                                        visitList[thisHeight][thisWidth] = true;
                                        subResult++;
                                        bfsQueue.add(new int[] {thisHeight, thisWidth});
                                    }
                                }
                            }
                        }
                    }

                    result = Math.max(subResult, result);
                }
            }
        }

        System.out.println(result);

    }

}

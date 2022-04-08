package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 두동전 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        String[][] board = new String[height][width];
        boolean[][][][] visitList = new boolean[height][width][height][width];

        int firstHeight = -1, firstWidth = -1;
        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];

                if(board[i][j].equals("o")){
                    if(firstHeight == -1){
                        firstHeight = i;
                        firstWidth = j;
                    }else{
                        bfsQueue.add(new int[] {firstHeight, firstWidth, i, j, 0});
                        visitList[firstHeight][firstWidth][i][j] = true;
                    }
                }
            }
        }

        int result = -1;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i++){
                firstHeight = (thisQueue[0] + upDown[i]);
                firstWidth = (thisQueue[1] + leftRight[i]);
                int secondHeight = (thisQueue[2] + upDown[i]);
                int secondWidth = (thisQueue[3] + leftRight[i]);

                if(firstHeight >= 0 && firstHeight < height && firstWidth >= 0 && firstWidth < width && 
                    secondHeight >= 0 && secondHeight < height && secondWidth >= 0 && secondWidth < width){
                    
                    if(board[firstHeight][firstWidth].equals("#")){
                        firstHeight = thisQueue[0];
                        firstWidth = thisQueue[1];
                    }

                    if(board[secondHeight][secondWidth].equals("#")){
                        secondHeight = thisQueue[2];
                        secondWidth = thisQueue[3];
                    }

                    if(!visitList[firstHeight][firstWidth][secondHeight][secondWidth]){
                        visitList[firstHeight][firstWidth][secondHeight][secondWidth] = true;
                        bfsQueue.add(new int[] {firstHeight, firstWidth, secondHeight, secondWidth, (thisQueue[4] + 1)});
                    }

                }else{
                    if(firstHeight < 0 || firstHeight >= height || firstWidth < 0 || firstWidth >= width){
                        if(secondHeight >= 0 && secondHeight < height && secondWidth >= 0 && secondWidth < width){
                            result = (thisQueue[4] + 1);
                            break loop;
                        }
                    }

                    if(secondHeight < 0 || secondHeight >= height || secondWidth < 0 || secondWidth >= width){
                        if(firstHeight >= 0 && firstHeight < height && firstWidth >= 0 && firstWidth < width){
                            result = (thisQueue[4] + 1);
                            break loop;
                        }
                    }
                }
            }
        }

        if(result == -1 || result > 10){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }

}

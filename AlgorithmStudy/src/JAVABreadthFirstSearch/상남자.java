package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상남자 {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = (scan.nextLine()).split(" ");
        int leftNum = Integer.parseInt(secondLine[0]), rightNum = Integer.parseInt(secondLine[1]);

        int[][] board = new int[height][width];
        boolean[][] visitList = new boolean[height][width];

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            String[] thirdLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(thirdLine[j]);

                if(board[i][j] == 2){
                    bfsQueue.add(new int[] {i, j, 0, 0});
                    visitList[i][j] = true;
                }
            }
        }

        int result = 1;
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 2 ; i++){
                int thisHeight = thisQueue[0];
                while(true){
                    thisHeight += upDown[i];

                    if(thisHeight >= 0 && thisHeight < height && thisQueue[1] >= 0 && thisQueue[1] < width){
                        if(!visitList[thisHeight][thisQueue[1]]){
                            if(board[thisHeight][thisQueue[1]] != 1){
                                result++;
                                visitList[thisHeight][thisQueue[1]] = true;
                                bfsQueue.add(new int[] {thisHeight, thisQueue[1], thisQueue[2], thisQueue[3]});
                            }else{
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                }
            }

            if(thisQueue[2] < leftNum){
                int thisWidth = (thisQueue[1] + leftRight[2]);

                if(thisQueue[0] >= 0 && thisQueue[0] < height && thisWidth >= 0 && thisWidth < width){
                    if(!visitList[thisQueue[0]][thisWidth]){
                        if(board[thisQueue[0]][thisWidth] != 1){
                            result++;
                            visitList[thisQueue[0]][thisWidth] = true;
                            bfsQueue.add(new int[] {thisQueue[0], thisWidth, (thisQueue[2]+1), thisQueue[3]});
                        }
                    }
                }
            }

            if(thisQueue[3] < rightNum){
                int thisWidth = (thisQueue[1] + leftRight[3]);

                if(thisQueue[0] >= 0 && thisQueue[0] < height && thisWidth >= 0 && thisWidth < width){
                    if(!visitList[thisQueue[0]][thisWidth]){
                        if(board[thisQueue[0]][thisWidth] != 1){
                            result++;
                            visitList[thisQueue[0]][thisWidth] = true;
                            bfsQueue.add(new int[] {thisQueue[0], thisWidth, thisQueue[2], (thisQueue[3]+1)});
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

}

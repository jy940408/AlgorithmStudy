package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 좀비바이러스 {
    
    public static void main(String[] args) {

        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        int[][] board = new int[height][width];
        int[][][] visitList = new int[height][width][2];

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);

                if(board[i][j] == 1){
                    bfsQueue.add(new int[] {i, j, 1, 0});
                    visitList[i][j] = new int[] {1, -1};

                }else if(board[i][j] == 2){
                    bfsQueue.add(new int[] {i, j, 2, 0});
                    visitList[i][j] = new int[] {2, -1};
                }
            }
        }

        int[] result = {0, 1, 1, 0};
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(visitList[thisQueue[0]][thisQueue[1]][0] != 3){
                for(int i = 0 ; i < 4 ; i++){
                    int thisHeight = (thisQueue[0] + upDown[i]);
                    int thisWidth = (thisQueue[1] + leftRight[i]);

                    if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                        if(board[thisHeight][thisWidth] != -1){
                            if(visitList[thisHeight][thisWidth][0] != 3){
                                if(visitList[thisHeight][thisWidth][0] == 0){
                                    visitList[thisHeight][thisWidth] = new int[] {thisQueue[2], (thisQueue[3]+1)};
                                    result[thisQueue[2]]++;
                                    bfsQueue.add(new int[] {thisHeight, thisWidth, thisQueue[2],(thisQueue[3]+1)});
                                
                                }else{
                                    if(thisQueue[2] != visitList[thisHeight][thisWidth][0]){
                                        if((thisQueue[3]+1) <= visitList[thisHeight][thisWidth][1]){
                                            result[visitList[thisHeight][thisWidth][0]]--;
                                            result[3]++;
                                            visitList[thisHeight][thisWidth] = new int[] {3, thisQueue[3]+1};
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result[1] + " " + result[2] + " " + result[3]);

    }

}

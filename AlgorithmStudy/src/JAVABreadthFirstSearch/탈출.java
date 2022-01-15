package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출 {
    
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
        
        String[][] board = new String[height][width];
        boolean[][] visitList = new boolean[height][width];

        Queue<int[]> bfsQueue = new LinkedList<>();
        int[] hedgehog = new int[2];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];

                if(board[i][j].equals("*")){
                    bfsQueue.add(new int[] {i, j, 0, 0});
                }else if(board[i][j].equals("S")){
                    hedgehog = new int[] {i, j};
                }
            }
        }
        bfsQueue.add(new int[] {hedgehog[0], hedgehog[1], 1, 0});

        int result = -1;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i ++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(!visitList[subHeight][subWidth]){
                        if(thisQueue[2] == 0){
                            if(board[subHeight][subWidth].equals(".")){
                                board[subHeight][subWidth] = "*";
                                visitList[subHeight][subWidth] = true;
                                bfsQueue.add(new int[] {subHeight, subWidth, 0, (thisQueue[3] + 1)});
                            }

                        }else if(thisQueue[2] == 1){
                            if(board[subHeight][subWidth].equals(".")){
                                visitList[subHeight][subWidth] = true;
                                bfsQueue.add(new int[] {subHeight, subWidth, 1, (thisQueue[3] + 1)});
                            
                            }else if(board[subHeight][subWidth].equals("D")){
                                result = (thisQueue[3] + 1);
                                break loop;
                            }

                        }
                    }
                }

            }
        }

        if(result == -1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(result);
        }
    }

}

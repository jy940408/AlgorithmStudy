package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인성문제있어 {
    
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int testCase = Integer.parseInt(scan.nextLine());

        for(int i = 0 ; i < testCase ; i++){
            
            String[] firstLine = (scan.nextLine()).split(" ");
            int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
            int obstacle = Integer.parseInt(firstLine[2]), power = Integer.parseInt(firstLine[3]);
            int startHeight = Integer.parseInt(firstLine[4]), startWidth = Integer.parseInt(firstLine[5]);
            int goalHeight = Integer.parseInt(firstLine[6]), goalWidth = Integer.parseInt(firstLine[7]);

            int[][] board = new int[height][width];
            boolean[][] visitList = new boolean[height][width];

            for(int j = 0 ; j < obstacle ; j++){
                String[] secondLine = (scan.nextLine()).split(" ");
                int subHeight = Integer.parseInt(secondLine[0]);
                int subWidth = Integer.parseInt(secondLine[1]);
                int subLength = Integer.parseInt(secondLine[2]);

                board[subHeight-1][subWidth-1] = subLength;
            }

            Queue<int[]> bfsQueue = new LinkedList<>();
            bfsQueue.add(new int[] {(startHeight-1), (startWidth-1), power});

            boolean resultCheck = false;
            loop:
            while(!bfsQueue.isEmpty()){
                int[] thisQueue = bfsQueue.poll();

                if(thisQueue[2] == 0){
                    break;
                }

                for(int j = 0 ; j < 4 ; j++){
                    int subHeight = (thisQueue[0] + upDown[j]);
                    int subWidth = (thisQueue[1] + leftRight[j]);

                    if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                        if(!visitList[subHeight][subWidth]){
                            if(board[thisQueue[0]][thisQueue[1]] >= board[subHeight][subWidth]){
                                visitList[subHeight][subWidth] = true;
                                bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]-1)});
                            
                                if(subHeight == (goalHeight-1) && subWidth == (goalWidth-1)){
                                    resultCheck = true;
                                    break loop;
                                }
                            
                            }else{
                                if(thisQueue[2] >= (board[subHeight][subWidth] - board[thisQueue[0]][thisQueue[1]])){
                                    bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]-1)});
                                
                                    if(subHeight == (goalHeight-1) && subWidth == (goalWidth-1)){
                                        resultCheck = true;
                                        break loop;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if(resultCheck){
                System.out.println("잘했어!!");
            }else{
                System.out.println("인성 문제있어??");
            }

        }

    }

}

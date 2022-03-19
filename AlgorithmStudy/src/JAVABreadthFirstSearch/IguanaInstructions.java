package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IguanaInstructions {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};

        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());

        String[][] board = new String[length][length];
        boolean[][] visitList = new boolean[length][length];
        for(int i = 0 ; i < length ; i++){
            String[] firstLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < length ; j++){
                board[i][j] = firstLine[j];
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, 0});

        int result = -1;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int thisHeight = thisQueue[0], thisWidth = thisQueue[1];
                while(true){
                    thisHeight += upDown[i];
                    thisWidth += leftRight[i];

                    if(thisHeight >= 0 && thisHeight < length && thisWidth >= 0 && thisWidth < length){
                        if(!visitList[thisHeight][thisWidth]){
                            if(board[thisHeight][thisWidth].equals(".")){
                                visitList[thisHeight][thisWidth] = true;
                                bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});
                            
                                if(thisHeight == (length-1) && thisWidth == (length-1)){
                                    result = (thisQueue[2]+1);
                                    break loop;
                                }

                            }else{
                                break;
                            }
                        }
                    
                    }else{
                        break;
                    }
                }

                if(result != -1){
                    break loop;
                }
            }
        }

        System.out.println(result);

    }

}

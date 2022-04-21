package JAVADynamicProgramming;

import java.util.Scanner;

public class 벼락치기 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int chapterNum = Integer.parseInt(firstLine[0]), timeNum = Integer.parseInt(firstLine[1]);

        int[][] board = new int[chapterNum][timeNum+1];
        int result = 0;
        for(int i = 0 ; i < chapterNum ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            int thisTime = Integer.parseInt(secondLine[0]), thisNum = Integer.parseInt(secondLine[1]);

            for(int j = 0 ; j < timeNum+1 ; j++){
                if(i != 0){
                    if(j >= thisTime){
                        board[i][j] = Math.max(board[i-1][j], (board[i-1][j-thisTime] + thisNum));
                    }else{
                        board[i][j] = board[i-1][j];
                    }
                }else{
                    if(j >= thisTime){
                        board[i][j] = thisNum;
                    }
                }

                result = Math.max(result, board[i][j]);
            }
        }

        System.out.println(result);

    }

}

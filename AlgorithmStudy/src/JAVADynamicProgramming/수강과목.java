package JAVADynamicProgramming;

import java.util.Scanner;

public class 수강과목 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int timeNum = Integer.parseInt(firstLine[0]), subjectNum = Integer.parseInt(firstLine[1]);

        int[][] board = new int[subjectNum][timeNum+1];
        for(int i = 0 ; i < subjectNum ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            int thisValue = Integer.parseInt(secondLine[0]), thisTime = Integer.parseInt(secondLine[1]);

            for(int j = 0 ; j < (timeNum+1) ; j++){
                if(i > 0){
                    if(j >= thisTime){
                        board[i][j] = Math.max(board[i-1][j], (board[i-1][j-thisTime] + thisValue));
                    }else{
                        board[i][j] = board[i-1][j];
                    }
                }else{
                    if(j >= thisTime){
                        board[i][j] += thisValue;
                    }
                }
                
            }

        }

        System.out.println(board[subjectNum-1][timeNum]);

    }

}

package JAVADynamicProgramming;

import java.util.Scanner;

public class 평범한배낭 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[] firstLine = (scan.nextLine()).split(" ");
        int roundNum = Integer.parseInt(firstLine[0]), weight = Integer.parseInt(firstLine[1]);

        int[][] board = new int[roundNum][weight+1];

        int result = 0;
        for(int i = 0 ; i < roundNum ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            int thisWeight = Integer.parseInt(secondLine[0]), thisValue = Integer.parseInt(secondLine[1]);
            
            for(int j = 0 ; j < (weight+1) ; j++){
                if(i > 0){
                    if(j >= thisWeight){
                        if((board[i-1][j] < (board[i-1][j-thisWeight] + thisValue))){
                            board[i][j] = (board[i-1][j-thisWeight] + thisValue);
                        
                        }else{
                            board[i][j] = board[i-1][j];
                        }
                    
                    }else{
                        board[i][j] = board[i-1][j];
                    }
                    
                }else{
                    if(j >= thisWeight){
                        board[i][j] = thisValue;
                    }   
                }

                result = Math.max(result, board[i][j]);
            }
        }

        System.out.println(result);

    }

}
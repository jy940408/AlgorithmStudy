package JAVADynamicProgramming;

import java.util.Scanner;

public class LCS {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[] firstLine = (scan.nextLine()).split("");
        String[] secondLine = (scan.nextLine()).split("");
        
        int[][] board = new int[firstLine.length][secondLine.length];
        int result = 0;
        for(int i = 0 ; i < firstLine.length ; i++){
            for(int j = 0 ; j < secondLine.length ; j++){
                if(firstLine[i].equals(secondLine[j])){
                    board[i][j]++;
                }

                if(i != 0 && j != 0){
                    board[i][j] += board[i-1][j-1];

                    if(board[i][j] == 0){
                        board[i][j] = board[i-1][j];
                    }
                
                }else if(i != 0 && j == 0){
                    if(board[i][j] == 0){
                        board[i][j] = board[i-1][j];
                    } 
                }

                if(j > 0 && board[i][j-1] > board[i][j]){
                    board[i][j] = board[i][j-1];
                }

                if(i > 0 && board[i-1][j] > board[i][j]){
                    board[i][j] = board[i-1][j];
                }

                result = Math.max(result, board[i][j]);
            }
        }

        System.out.println(result);

    }

}

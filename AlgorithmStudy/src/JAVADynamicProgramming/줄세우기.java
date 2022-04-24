package JAVADynamicProgramming;

import java.util.Scanner;

public class 줄세우기 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int roundNum = Integer.parseInt(scan.nextLine());

        int[] board = new int[roundNum];
        for(int i = 0 ; i < roundNum ; i++){
            board[i] = Integer.parseInt(scan.nextLine());
        }

        int[][] dp = new int[roundNum][roundNum];
        int subResult = 0;
        for(int i = 0 ; i < roundNum ; i++){
            for(int j = 0 ; j < roundNum ; j++){
                if(i == 0){
                    dp[i][i] = 1;
                    if(board[i] < board[j]){
                        dp[i][j] = (dp[i][i] + 1);
                    }

                }else{
                    dp[i][i] = Math.max(dp[i-1][i], 1);
                    if(i <= j){
                        if(board[i] < board[j]){
                            dp[i][j] = Math.max(dp[i-1][j], (dp[i][i]+1));
                        }else{
                            dp[i][j] = dp[i-1][j];
                        }

                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                
                subResult = Math.max(subResult, dp[i][j]);
            }
        }

        System.out.println(roundNum-subResult);

    }

}
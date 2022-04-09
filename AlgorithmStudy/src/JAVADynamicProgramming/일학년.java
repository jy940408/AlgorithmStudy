package JAVADynamicProgramming;

import java.util.Scanner;

public class 일학년 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int allNum = Integer.parseInt(scan.nextLine());
        String[] firstLine = (scan.nextLine()).split(" ");
        int[] numList = new int[allNum];
        for(int i = 0 ; i < allNum ; i++){
            numList[i] = Integer.parseInt(firstLine[i]);
        }

        long[][] dp = new long[allNum-1][21];
        dp[0][numList[0]] = 1;

        for(int i = 1 ; i < allNum-1 ; i++){
            for(int j = 0 ; j < 21 ; j++){
                if(dp[i-1][j] != 0){
                    if((j + numList[i]) <= 20){
                        dp[i][j + numList[i]] += dp[i-1][j];
                    }

                    if((j - numList[i] >= 0)){
                        dp[i][j - numList[i]] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[allNum-2][numList[allNum-1]]);

    }

}

package JAVADynamicProgramming;

import java.util.Scanner;

public class 쉬운계단수 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int testNum = Integer.parseInt(scan.nextLine());

        int[][] board = new int[(testNum+1)][10];
        for(int i = 1 ; i < 10 ; i++){
            board[1][i] = 1;
        }

        for(int i = 2 ; i < (testNum + 1) ; i++){
            board[i][0] = board[i - 1][1];
            board[i][9] = board[i - 1][8];

            for(int j = 2 ; j < 9 ; j++){
                board[i][j] = (board[i-1][j-1] + board[i-1][j+1]);
            }
        }

        int result = 0;
        for(int i = 0 ; i < 10 ; i++){
            result += board[testNum][i];
        }

        System.out.println(result%1000000000);

    }

}

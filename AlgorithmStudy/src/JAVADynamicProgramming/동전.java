package JAVADynamicProgramming;

import java.util.Scanner;

public class 동전 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int roundNum = Integer.parseInt(scan.nextLine());

        for(int i = 0 ; i < roundNum ; i++){
            int coinNum = Integer.parseInt(scan.nextLine());
            String[] firstLine = (scan.nextLine()).split(" ");
            int[] coinList = new int[coinNum];
            for(int j = 0 ; j < coinNum ; j++){
                coinList[j] = Integer.parseInt(firstLine[j]);
            }
            int goalNum = Integer.parseInt(scan.nextLine());

            int[][] board = new int[coinNum][goalNum+1];
            for(int j = 0 ; j < coinNum ; j++){
                board[j][0] = 1;
                for(int k = 1 ; k < (goalNum+1) ; k++){
                    if(j > 0){
                        board[j][k] = board[j-1][k];
                    }
                    if((k-coinList[j]) >= 0){
                        board[j][k] += board[j][k-coinList[j]];
                    }
                }
            }

            System.out.println(board[coinNum-1][goalNum]);
        }

    }

}

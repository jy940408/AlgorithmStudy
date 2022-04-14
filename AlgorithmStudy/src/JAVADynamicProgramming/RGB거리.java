package JAVADynamicProgramming;

import java.util.Scanner;

public class RGB거리 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int houseNum = Integer.parseInt(scan.nextLine());

        int[][] board = new int[houseNum][3];
        for(int i = 0 ; i < houseNum ; i++){
            String[] firstLine = (scan.nextLine()).split(" ");
            int[] priceList = new int[3];
            for(int j = 0 ; j < 3 ; j++){
                priceList[j] = Integer.parseInt(firstLine[j]);
            }

            if(i == 0){
                board[i] = priceList;
            
            }else{
                for(int j = 0 ; j < 3 ; j++){
                    int subResult = 0;
                    for(int k = 0 ; k < 3 ; k++){
                        if(j != k){
                            if(subResult == 0){
                                subResult = (priceList[j] + board[i-1][k]);
                            
                            }else{
                                board[i][j] = Math.min(subResult, (priceList[j] + board[i-1][k]));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(Math.min(Math.min(board[(houseNum-1)][0], board[houseNum-1][1]), board[(houseNum-1)][2]));

    }

}

package JAVADynamicProgramming;

import java.util.Scanner;

public class 동전1 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int coinNum = Integer.parseInt(firstLine[0]), goalNum = Integer.parseInt(firstLine[1]);

        int[] board = new int[goalNum+1];
        board[0] = 1;
        for(int i = 0 ; i < coinNum ; i++){
            int thisCoin = Integer.parseInt(scan.nextLine());

            for(int j = 1 ; j < (goalNum+1) ; j++){
                if((j-thisCoin) >= 0){
                    board[j] += board[j-thisCoin];
                }
            }
        }

        System.out.println(board[goalNum]);

    }

}

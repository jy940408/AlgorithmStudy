package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class 모독 {
    
        public static void main(String[] args) {
            
            Scanner scan = new Scanner(System.in);

            int allNum = Integer.parseInt(scan.nextLine());

            Integer[] board = new Integer[allNum];
            for(int i = 0 ; i < allNum ; i++){
                board[i] = Integer.parseInt(scan.nextLine());
            }

            Arrays.sort(board);

            long result = 0;
            if(board[0] != 1){
                result += (board[0] - 1);
                board[0] = 1;
            }
            
            for(int i = 1 ; i < allNum ; i++){
                if(board[i-1] < board[i]){
                    result += (board[i] - (board[i-1]+1));
                    board[i] = (board[i-1]+1);
                }
            }

            System.out.println(result);

        }

}

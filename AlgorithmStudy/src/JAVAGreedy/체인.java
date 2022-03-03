package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class 체인 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int roundNum = Integer.parseInt(scan.nextLine());
        
        String[] firstLine = (scan.nextLine()).split(" ");
        int[] board = new int[roundNum];
        for(int i = 0 ; i < roundNum ; i++){
            board[i] = Integer.parseInt(firstLine[i]);
        }

        Arrays.sort(board);

        int subResult = 0;
        int result = 0;
        for(int i = 0 ; i < roundNum ; i++){
            int thisCount = roundNum-i-1;

            subResult += board[i];
            if(subResult >= thisCount){
                result = thisCount;
                break;
            }
        }

        System.out.println(result);

    }

}

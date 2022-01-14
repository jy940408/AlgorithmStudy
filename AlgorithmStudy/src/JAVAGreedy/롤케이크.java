package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class 롤케이크 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[] firstLine = (scan.nextLine()).split(" ");
        int cakeNum = Integer.parseInt(firstLine[0]), roundNum = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = (scan.nextLine()).split(" ");
        int[] board = new int[cakeNum];
        for(int i = 0 ; i < cakeNum ; i++){
            board[i] = Integer.parseInt(secondLine[i]);
        }

        Arrays.sort(board);

        int result = 0, checkNum = 0;
        boolean resultCheck = false;
        for(int i = 0 ; i < cakeNum ; i++){
            if(board[i]%10 == 0){
                if((checkNum + (board[i]/10 - 1)) <= roundNum){
                    result += board[i]/10;
                    checkNum += (board[i]/10)-1;
                }else{
                    result += (roundNum - checkNum);
                    resultCheck = true;
                    break;
                }
            }
        }

        if(!resultCheck){
            for(int i = 0 ; i < cakeNum ; i++){
                if(board[i]%10 != 0){
                    if((checkNum + board[i]/10) <= roundNum){
                        result += board[i]/10;
                        checkNum += board[i]/10;
                    }else{
                        result += (roundNum - checkNum);
                        break;    
                    }
                }
            }
        }

        System.out.println(result);

    }

}

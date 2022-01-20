package JAVABinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 입국심사 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int gateNum = Integer.parseInt(firstLine[0]), friendNum = Integer.parseInt(firstLine[1]);

        long[] board = new long[gateNum];
        for(int i = 0 ; i < gateNum ; i++){
            board[i] = Long.parseLong(scan.nextLine());
        }

        Arrays.sort(board);

        long start = board[0], mid = 0, last = (board[(gateNum-1)]*friendNum);
        long result = 0;
        while(start <= last){

            mid = (start + last)/2;

            long subResult = 0;
            for(int i = 0 ; i < gateNum ; i++){
                if(subResult >= friendNum){
                    break;
                }
                
                subResult += (mid/board[i]);
            }

            if(subResult >= friendNum){
                result = mid;
                last = mid - 1;
            }else{
                start = mid + 1;
            }

        }

        System.out.println(result);

    }

}

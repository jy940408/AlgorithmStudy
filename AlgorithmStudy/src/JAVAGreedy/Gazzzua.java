package JAVAGreedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Gazzzua {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int coinNum = Integer.parseInt(scan.nextLine());
        String[] firstLine = (scan.nextLine()).split(" ");
        Integer[] board = new Integer[coinNum];
        Integer[] sortedBoard = new Integer[coinNum];
        int maxNum = 0;
        for(int i = 0 ; i < coinNum ; i++){
            board[i] = Integer.parseInt(firstLine[i]);
            maxNum = Math.max(maxNum, board[i]);
        }
        int subNum = 0, result = 0, subResult = 0;
        for(int i = 0 ; i < coinNum ; i++){
            if(board[i] < maxNum){
                subResult += board[i];
                subNum++;
            }else{
                result += (maxNum*subNum - subResult);
                if(i != (coinNum-1)){
                    maxNum = 0;
                    for(int j = (i+1) ; j < coinNum ; j++){
                        maxNum = Math.max(maxNum, board[j]);
                    }
                }
                subNum = 0;
                subResult = 0;
            }
        }

        System.out.println(result);
    }

}

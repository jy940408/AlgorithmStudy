package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class 시간관리하기 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        int workNum = Integer.parseInt(scan.nextLine());

        int[][] board = new int[workNum][2];
        for(int i = 0 ; i < workNum ; i++){
            String[] firstLine = (scan.nextLine()).split(" ");
            board[i][0] = Integer.parseInt(firstLine[0]);
            board[i][1] = Integer.parseInt(firstLine[1]);
        }

        Arrays.sort(board, new Comparator<int[]>(){
            @Override
            public int compare(int[] firstNum, int[] secondNum){
                return secondNum[1] - firstNum[1];
            }
        });
        Arrays.sort(board, new Comparator<int[]>(){
            @Override
            public int compare(int[] firstNum, int[] secondNum){
                if(secondNum[1] - firstNum[1] == 0){
                    return secondNum[0] - firstNum[0];
                }
                return secondNum[1] - firstNum[1];
            }
        });

        long thisTime = board[0][1];
        for(int i = 0 ; i < workNum ; i++){
            if(thisTime >= board[i][1]){
               thisTime = (board[i][1] - board[i][0]);
            }else{
                thisTime -= board[i][0];
            }
        }

        if(thisTime >= 0){
            System.out.println(thisTime);
        }else{
            System.out.println(-1);
        }

    }

}

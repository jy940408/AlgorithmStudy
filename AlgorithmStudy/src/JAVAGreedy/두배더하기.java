package JAVAGreedy;

import java.util.Scanner;

public class 두배더하기 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        
        String[] firstLine = (scan.nextLine()).split(" ");
        int[] board = new int[length];
        for(int i = 0 ; i < length ; i++){
            board[i] = Integer.parseInt(firstLine[i]);
        }

        int divideNum = 0;
        int minusNum = 0;
        for(int i = 0 ; i < length ; i++){
            int subNum = 0;
            while(true){
                if(board[i] != 0){
                    if(board[i]%2 == 1){
                        minusNum++;
                        board[i]--;
                    }else{
                        board[i] /= 2;
                        subNum++;
                    }
                }

                if(board[i] == 0){
                    divideNum = Math.max(divideNum, subNum);
                    break;
                }
            }
        }

        System.out.println((divideNum + minusNum));

    }

}

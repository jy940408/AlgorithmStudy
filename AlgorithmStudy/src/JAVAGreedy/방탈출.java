package JAVAGreedy;

import java.util.Scanner;

public class 방탈출 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int buttonNum = Integer.parseInt(scan.nextLine());
 
        int[] board = new int[buttonNum];
        String[] firstLine  = (scan.nextLine()).split(" ");
        for(int i = 0 ; i < buttonNum ; i++){
            board[i] = Integer.parseInt(firstLine[i]);
        }

        int result = 0;
        for(int i = 0 ; i < buttonNum ; i++){
            if(board[i] == 1){
                result += 1;
                for(int j = 0 ; j < 3 ; j++){
                    if((i+j) < buttonNum){
                        if(board[i+j] == 0){
                            board[i+j] = 1;
                        }else{
                            board[i+j] = 0;
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

}

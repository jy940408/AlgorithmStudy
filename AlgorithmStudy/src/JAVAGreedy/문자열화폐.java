package JAVAGreedy;

import java.util.Scanner;

public class 문자열화폐 {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int roundNum = Integer.parseInt(firstLine[0]), goalNum = Integer.parseInt(firstLine[1]);

        int[] board = new int[27];
        board[1] = roundNum;
        int resultNum = roundNum;

        for(int i = 26 ; i > 1 ; i--){
            int thisNum = (goalNum-resultNum)/(i-1);
            if(thisNum > 0){
                resultNum = (resultNum - thisNum) + (i*thisNum);
                board[1] -= thisNum;
                board[i] += thisNum;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < 27 ; i++){
            if(board[i] != 0){
                for(int j = 0 ; j < board[i] ; j++){
                    result.append(Character.toString((char)(i+64)));
                }
            }
        }

        if(resultNum == goalNum && board[1] >= 0){
            System.out.println(result);
        }else{
            System.out.println("!");
        }
    }

}

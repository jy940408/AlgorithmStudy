package JAVAGreedy;

import java.util.Scanner;

public class 아름다운문자열 {
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        String[] fullWord = (scan.nextLine()).split("");
        String[] goalWord = (scan.nextLine()).split("");

        int[] idxList = new int[26];
        for(int i = 0 ; i < goalWord.length ; i++){
            idxList[goalWord[i].charAt(0)-97] = (i+1);
        }

        int[] board = new int[goalWord.length+1];
        for(int i = 0 ; i < fullWord.length ; i++){
            if(idxList[fullWord[i].charAt(0)-97] != 0){
                if(idxList[fullWord[i].charAt(0)-97] == 1){
                    board[idxList[fullWord[i].charAt(0)-97]]++;
                    
                }else{
                    if(board[idxList[fullWord[i].charAt(0)-97]-1] > 0){
                        board[idxList[fullWord[i].charAt(0)-97]-1]--;
                        board[idxList[fullWord[i].charAt(0)-97]]++;
                    }
                }
            }
        }

        System.out.println(board[goalWord.length]);

    }

}
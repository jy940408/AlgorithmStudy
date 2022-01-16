package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class A와B {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] startWord = (scan.nextLine()).split("");
        String[] goalWord = (scan.nextLine()).split("");

        while(startWord.length < goalWord.length){
            if(startWord.length < goalWord.length){
                if(goalWord[(goalWord.length-1)].equals("A")){
                    String[] subWord = new String[goalWord.length-1];
                    for(int i = 0 ; i < (goalWord.length-1) ; i++){
                        subWord[i] = goalWord[i];
                    }
                    goalWord = subWord;
                }else{
                    String[] subWord = new String[goalWord.length-1];
                    for(int i = (goalWord.length-2) ; i > -1 ; i--){
                        subWord[(goalWord.length-2) - i] = goalWord[i];
                    }
                    goalWord = subWord;
                }
            }
        }

        if(Arrays.equals(startWord, goalWord)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

}

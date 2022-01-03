package JAVAGreedy;

import java.util.Scanner;

public class 폴리오미노 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[] sentence = (scan.nextLine()).split("");

        String result = "";
        int round = 0;
        for(int i = 0 ; i < sentence.length ; i++){

            if(sentence[i].equals("X")){
                round++;

                if(i == (sentence.length-1)){
                    if((round%4)%2 == 0){
                        result += "A".repeat((round/4)*4);
                        result += "B".repeat(round%4);
                    }else{
                        result = "-1";
                        break;
                    }
                }
            }else if(sentence[i].equals(".") || (i == (sentence.length-1))){
                if((round%4)%2 == 0){
                    result += "A".repeat((round/4)*4);
                    result += "B".repeat(round%4);
                }else{
                    result = "-1";
                    break;
                }

                round = 0;
                result += ".";
            }
        }

        System.out.println(result);

    }
}

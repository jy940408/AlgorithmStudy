package JAVAImplementation;

import java.util.Scanner;

public class 아스키도형 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        float result = 0;
        for(int i = 0 ; i < height ; i++){
            firstLine = (scan.nextLine()).split("");
            boolean startCheck = false;

            for(int j = 0 ; j < width ; j++){
                if(firstLine[j].equals("/")){
                    result += 0.5;
                    if(!startCheck){
                        startCheck = true;
                    }else{
                        startCheck = false;
                    }

                }else if(firstLine[j].equals("\\")){
                    result += 0.5;
                    if(!startCheck){
                        startCheck = true;
                    }else{
                        startCheck = false;
                    }

                }else{
                    if(startCheck){
                        result++;
                    }
                }
            }
        }

        System.out.println((int)result);

    }

}

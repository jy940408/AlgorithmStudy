package JAVAGreedy;

import java.util.Scanner;

public class FromAtoB {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int startNum = Integer.parseInt(firstLine[0]);
        int goalNum = Integer.parseInt(firstLine[1]);

        int result = 0;
        while(startNum != goalNum){
            if(startNum > goalNum){
                result++;
                if(startNum%2 == 0){
                    startNum /= 2;
                }else{
                    startNum++;
                }

            }else{
                result += (goalNum - startNum);
                break;
            }
        }

        System.out.println(result);

    }

}
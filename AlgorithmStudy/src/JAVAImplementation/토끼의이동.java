package JAVAImplementation;

import java.util.Scanner;

public class 토끼의이동 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        long length = Integer.parseInt(firstLine[0]);
        long turn = Integer.parseInt(firstLine[1]);

        String[] testCase = (scan.nextLine()).split("");

        long[] upDown = {1, 0, -1, 0, 0};
        long[] leftRight = {0, 0, 0, -1, 1};

        long[] thisLocation = {1, 1};
        long result = 1;
        for(String i: testCase){

            thisLocation[0] += upDown[((int)i.charAt(0)-68)%5];
            thisLocation[1] += leftRight[((int)i.charAt(0)-68)%5];

            long lineNum = ((thisLocation[0] + thisLocation[1]) - 1);
            if(lineNum < (length+1)){
                long lineStart = ((lineNum*(lineNum-1)/2));
                if(lineNum%2 == 0){
                    result += (lineStart + thisLocation[0]);
                }else{
                    result += (lineStart +(lineNum-(thisLocation[0]-1)));
                }
            
            }else{
                long thisNum = (2*length-lineNum);
                long lineStart = ((length*(length+1))/2) + ((length*(length-1))/2 - (thisNum+1)*thisNum/2);
                long subLocation = (thisLocation[0] - (lineNum-length));
                if(lineNum%2 == 0){
                    result += (lineStart + subLocation);
                }else{
                    result += (lineStart + (thisNum-(subLocation-1)));
                }
            }

        }

        System.out.println(result);

    }

}

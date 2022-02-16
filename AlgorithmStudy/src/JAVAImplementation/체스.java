package JAVAImplementation;

import java.util.Scanner;

public class 체스 {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] upDown = {-1, -1, 1, 1};
        int[] leftRight = {-1, 1, -1, 1};

        int roundNum = Integer.parseInt(scan.nextLine());

        for(int round = 0 ; round < roundNum ; round++){
            String[] firstLine = (scan.nextLine()).split(" ");
            int startWidth = (firstLine[0].charAt(0)-64), startHeight = Integer.parseInt(firstLine[1]);
            int goalWidth = (firstLine[2].charAt(0)-64), goalHeight = Integer.parseInt(firstLine[3]);

            int[] midRoot = new int[2];
            boolean resultCheck = false;
            loop:
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 4 ; j++){

                    if((startHeight+(i*upDown[j])) >= 1 && (startHeight+(i*upDown[j])) < 9
                    && (startWidth+(i*leftRight[j])) >= 1 && (startWidth+(i*leftRight[j])) < 9){
                        if(Math.abs(goalHeight - (startHeight+(i*upDown[j]))) == Math.abs(goalWidth - (startWidth+(i*leftRight[j])))){
                            midRoot[0] = (startHeight+(i*upDown[j]));
                            midRoot[1] = (startWidth+(i*leftRight[j]));

                            resultCheck = true;
                            break loop;
                        }
                    }
                }
            }

            if(resultCheck){
                if(startWidth == goalWidth && startHeight == goalHeight){
                    System.out.println("0 " + ((char)(startWidth+64)) + " " + startHeight);
                }else if(startWidth == midRoot[1] && startHeight == midRoot[0]){
                    System.out.println("1 " + ((char)(startWidth+64)) + " " + startHeight + " " + ((char)(goalWidth+64)) + " " + goalHeight);
                }else{
                    System.out.println("2 " + ((char)(startWidth+64)) + " " + startHeight + " " + 
                    ((char)(midRoot[1]+64)) + " " + midRoot[0] + " " + ((char)(goalWidth+64)) + " " + goalHeight);
                }
            }else{
                System.out.println("Impossible");
            }

        }

    }

}

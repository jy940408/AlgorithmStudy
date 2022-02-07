package JAVAImplementation;

import java.io.IOException;
import java.util.Scanner;

public class 정사면체 {
    
    public static void main(String[] args) throws IOException{
        
        Scanner scan = new Scanner(System.in);

        int[] firstSide = {1, 0, 0, 0};
        int[] secondSide = {2, 3, 1, 2};
        int[] thirdSide = {3, 2, 3, 1};

        int roundNum = Integer.parseInt(scan.nextLine());

        for(int i = 0 ; i < roundNum ; i++){
            String[] firstLine = (scan.nextLine()).split(" ");
            int[] firstBoard = new int[4], secondBoard = new int[4];
            
            for(int j = 0 ; j < 8 ; j++){
                if(j < 4){
                    firstBoard[j] = Integer.parseInt(firstLine[j]);
                }else{
                    secondBoard[j-4] = Integer.parseInt(firstLine[j]);
                }
            }

            int result = 0;
            int[] subFirst = new int[3], subSecond = new int[3];
            loop:
            for(int j = 0 ; j < 4 ; j++){
                for(int k = 0 ; k < 4 ; k++){

                    if(firstBoard[j] == secondBoard[k]){
                        subFirst = new int[] {firstBoard[firstSide[j]], firstBoard[secondSide[j]], firstBoard[thirdSide[j]]};
                        subSecond = new int[] {secondBoard[firstSide[k]], secondBoard[secondSide[k]], secondBoard[thirdSide[k]]};
                    
                        for(int l = 0 ; l < 3 ; l++){
                            int subNum = subSecond[0];
                            subSecond[0] = subSecond[1];
                            subSecond[1] = subSecond[2];
                            subSecond[2] = subNum;
                            
                            for(int m = 0 ; m < 3 ; m++){
                                if(subFirst[m] == subSecond[m]){
                                    if(m == 2){
                                        result = 1;
                                        break loop;
                                    }
                                }else{
                                    break;
                                }
                            }
    
                        }
                    }
                    
                }
            }

            System.out.println(result);

        }

    }

}

package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class 행복유치원 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int kidsNum = Integer.parseInt(firstLine[0]), groupNum = Integer.parseInt(firstLine[1]);

        String[] secondLine = (scan.nextLine()).split(" ");
        int[] heightList = new int[kidsNum];
        for(int i = 0 ; i < kidsNum ; i++){
            heightList[i] = Integer.parseInt(secondLine[i]);
        }

        int[] diffList = new int[kidsNum-1];
        for(int i = 1 ; i < kidsNum ; i++){
            diffList[i-1] = (heightList[i]-heightList[i-1]);
        }
        Arrays.sort(diffList);

        int result = 0;
        for(int i = 0 ; i < (kidsNum-groupNum) ; i++){
            result += diffList[i];
        }

        System.out.println(result);

    }

}

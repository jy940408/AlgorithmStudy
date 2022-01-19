package JAVABinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 히오스프로게이머 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int memberNum = Integer.parseInt(firstLine[0]);
        int levelNum = Integer.parseInt(firstLine[1]);

        int[] levelList = new int[memberNum];
        for(int i = 0 ; i < memberNum ; i++){
            levelList[i] = Integer.parseInt(scan.nextLine());
        }

        Arrays.sort(levelList);

        int start = levelList[0], mid = 0, last = (levelList[(memberNum-1)] + levelNum);
        int result = 0;
        while(start <= last){

            long levelSum = 0;
            mid = (start+last)/2;

            for(int i = 0 ; i < memberNum ; i++){
                if(levelList[i] >= mid){
                    break;
                }

                levelSum += (mid - levelList[i]);
            }

            if(levelSum <= levelNum){
                result = mid;
                start = mid + 1;
            }else{
                last = mid - 1;
            }

        }

        System.out.println(result);

    }

}

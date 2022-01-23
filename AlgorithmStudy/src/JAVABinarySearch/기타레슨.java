package JAVABinarySearch;

import java.util.Scanner;

public class 기타레슨 {
   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int lessonNum = Integer.parseInt(firstLine[0]), bluerayNum = Integer.parseInt(firstLine[1]);

        int[] lessonList = new int[lessonNum];
        int start = 0, mid = 0, last = 0, result = 1000000000;
        
        String[] secondLine = (scan.nextLine()).split(" ");
        for(int i = 0 ; i < lessonNum ; i++){
            lessonList[i] = Integer.parseInt(secondLine[i]);

            last += lessonList[i];
            start = Math.max(lessonList[i], start);
        }

        while(start <= last){
            mid = (start+last)/2;

            int subResult = 0, checkNum = 0;
            for(int i = 0 ; i < lessonNum ; i++){
                if((checkNum + lessonList[i]) > mid){
                    checkNum = 0;
                    subResult += 1;
                }

                checkNum += lessonList[i];
            }

            if(checkNum != 0){
                subResult += 1;
            }

            if(subResult > bluerayNum){
                start = (mid + 1);
            }else{
                last = (mid - 1);
                result = Math.min(result, mid);
            }
        }

        System.out.println(result);

    }

}
